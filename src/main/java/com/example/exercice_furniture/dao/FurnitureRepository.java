package com.example.exercice_furniture.dao;

import com.example.exercice_furniture.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
}
