package org.example.servicesapp.services;

import org.example.servicesapp.User;
import org.example.servicesapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser() {
        User user = userRepository.insert(new User());
        return user;
    }
}
