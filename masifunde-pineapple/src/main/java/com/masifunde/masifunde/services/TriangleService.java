package com.masifunde.masifunde.services;

import com.masifunde.masifunde.models.Triangle;
import org.springframework.http.ResponseEntity;

public interface TriangleService {
    ResponseEntity<Triangle> saveOrUpdate(Triangle triangle);
}
