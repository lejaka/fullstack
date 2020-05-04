package com.masifunde.masifunde.services;
import com.masifunde.masifunde.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<User> saveOrUpdate(User user);
}
