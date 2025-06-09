package com.example.authorbookrest.service;

import com.example.authorbookrest.entity.User;
import java.util.Optional;

public interface UserService {

    void save(User user);

    Optional<User> findByEmail(String email);
}