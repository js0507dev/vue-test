package com.sjs.test.user.service;

import com.sjs.test.user.domain.UserVo;
import com.sjs.test.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(UserVo userVo) {
        validateDuplicateUser(userVo);
        userRepository.save(userVo);

        return userVo.getId();
    }

    private void validateDuplicateUser(UserVo user) {
        Optional<UserVo> findUsers = userRepository.findByEmail(user.getEmail());
        findUsers.ifPresent(userVo -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<UserVo> findUsers() {
        return userRepository.findAll();
    }

    public UserVo findOne(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 사용자입니다."));
    }
}
