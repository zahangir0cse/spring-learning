package com.iict.learning.springlearning.service;

import com.iict.learning.springlearning.model.Role;
import com.iict.learning.springlearning.model.User;
import com.iict.learning.springlearning.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
@AllArgsConstructor
public class DbInit {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData(){
        Role role = new Role();
        role.setName("ADMIN");
        User user = new User();
        user.setEmail("admin@admin.com");
        user.setIsActive(true);
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }
}
