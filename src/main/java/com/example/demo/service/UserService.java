package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Modifying
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public User findFirstByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }


}
