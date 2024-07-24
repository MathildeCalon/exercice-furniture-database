package com.example.exercice_furniture.dao;

import com.example.exercice_furniture.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
