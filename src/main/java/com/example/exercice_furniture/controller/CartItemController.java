package com.example.exercice_furniture.controller;

import com.example.exercice_furniture.dao.CartItemRepository;
import com.example.exercice_furniture.entity.CartItem;
import com.example.exercice_furniture.entity.Furniture;
import com.example.exercice_furniture.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartItemController {
    private final CartItemRepository cartItemRepository;
    private final FurnitureService furnitureService;

    public CartItemController(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    @GetMapping("/cartitem")
    public String cartitem(Model model) {
        model.addAttribute("items", cartItemRepository.findAll());
        return "cartItem";
    }

    @PostMapping("/addToCart/{id}")
    public String addToCart(@ModelAttribute CartItem cartItem, @PathVariable int id) {
        Furniture furniture = furnitureService.findFurnitureById(id);
        cartItem.setFurniture(furniture);
        cartItemRepository.save(cartItem);
        return "redirect:/cartitem";
    }

    @GetMapping("/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable int id) {
        cartItemRepository.deleteById(id);
        return "redirect:/cartitem";
    }

    @GetMapping("/clearCart")
    public String clearCart() {
        cartItemRepository.deleteAll();
        return "redirect:/cartitem";
    }

}
