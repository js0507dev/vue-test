package com.sjs.test.user.service;

import com.sjs.test.user.domain.UserVo;
import com.sjs.test.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Test
    public void 회원가입() throws Exception {
        //given
        UserVo userVo = new UserVo();
        userVo.setEmail("test@naver.com");
        userVo.setPassword(passwordEncoder.encode("test"));

        //when
        Long userId = userService.join(userVo);

        //then
        assertEquals(userVo, userRepository.findById(userId).get());
    }

    @Test
    public void 중복확인_예외() throws Exception {
        //given
        UserVo userVo1 = new UserVo();
        userVo1.setEmail("test@naver.com");
        userVo1.setPassword(passwordEncoder.encode("test"));

        UserVo userVo2 = new UserVo();
        userVo2.setEmail("test@naver.com");
        userVo2.setPassword(passwordEncoder.encode("test2"));

        //when
        userService.join(userVo1);
        try{
            userService.join(userVo2);
        } catch ( IllegalStateException e ) {
            return;
        }

        //then
        fail("여기까지 오면 안됨");
    }
}