package com.masifunde.masifunde.repository;

import com.masifunde.masifunde.models.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriangleRepo extends JpaRepository<Triangle, Integer> {
    List<Triangle> getByNameOfShape(String nameOfShape);
    List<Triangle> getBySymbolToPrint(String symbolToPrint);
}
