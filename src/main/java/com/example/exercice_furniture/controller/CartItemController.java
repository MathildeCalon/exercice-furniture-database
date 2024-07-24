package com.example.exercice_furniture.controller;

import com.example.exercice_furniture.dao.CartItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartItemController {
    private final CartItemRepository cartItemRepository;

    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @GetMapping("/cartitem")
    public String cartitem(Model model) {
        model.addAttribute("items", cartItemRepository.findAll());
        return "cartItem";
    }
}
