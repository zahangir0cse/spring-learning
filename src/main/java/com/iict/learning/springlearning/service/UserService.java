package com.iict.learning.springlearning.service;

import com.iict.learning.springlearning.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> list();
}
