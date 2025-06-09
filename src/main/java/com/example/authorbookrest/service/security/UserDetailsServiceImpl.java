package com.example.authorbookrest.service.security;

import com.example.authorbookrest.entity.User;
import com.example.authorbookrest.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userService.findByEmail(username);
        if (byEmail.isPresent()) {
           User userFromDB = byEmail.get();
            return new CurrentUser(userFromDB);
        }
            throw new UsernameNotFoundException("User with" + username + "does not exist");
    }
}
