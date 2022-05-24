package com.iict.learning.springlearning.service.impl;

import com.iict.learning.springlearning.model.User;
import com.iict.learning.springlearning.repository.UserRepository;
import com.iict.learning.springlearning.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
