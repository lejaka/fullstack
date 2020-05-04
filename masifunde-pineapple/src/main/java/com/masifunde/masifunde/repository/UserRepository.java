package com.masifunde.masifunde.repository;

import com.masifunde.masifunde.models.User;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getByEmail(String email);
    List<User> getByDisplayName(String displayName);
}

