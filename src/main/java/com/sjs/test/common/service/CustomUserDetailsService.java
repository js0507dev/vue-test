package com.sjs.test.common.service;

import com.sjs.test.user.domain.UserVo;
import com.sjs.test.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + username + " not found"));

        return new User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }

    public static Collection<? extends GrantedAuthority> getAuthorities(UserVo user) {
        String[] userRoles = user.getRoles().stream()
                .map(role -> role.getRoleName())
                .toArray(String[]::new);

        return AuthorityUtils.createAuthorityList(userRoles);
    }
}
