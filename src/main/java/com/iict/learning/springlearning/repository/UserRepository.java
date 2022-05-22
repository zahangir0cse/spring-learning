package com.iict.learning.springlearning.repository;

import com.iict.learning.springlearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
