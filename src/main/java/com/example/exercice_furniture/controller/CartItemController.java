package com.example.exercice_furniture.controller;

import com.example.exercice_furniture.entity.CartItem;
import com.example.exercice_furniture.entity.Furniture;
import com.example.exercice_furniture.service.CartItemService;
import com.example.exercice_furniture.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartItemController {
    private final FurnitureService furnitureService;
    private final CartItemService cartItemService;

    public CartItemController(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/cartitem")
    public String cartitem(Model model) {
        model.addAttribute("items", cartItemService.getAllCartItems());
        return "cartItem";
    }

    @PostMapping("/addToCart/{id}")
    public String addToCart(@ModelAttribute CartItem cartItem, @PathVariable int id) {
        Furniture furniture = furnitureService.findFurnitureById(id);
        cartItem.setFurniture(furniture);
        cartItemService.addToCart(cartItem);
        furnitureService.decreaseStock(furniture, cartItem.getQuantity());
        return "redirect:/cartitem";
    }

    @PostMapping("/deleteCartItem")
    public String deleteCartItem(@ModelAttribute CartItem cartItem) {
        cartItemService.removeFromCart(cartItem);
        return "redirect:/cartitem";
    }

    @GetMapping("/clearCart")
    public String clearCart() {
        cartItemService.clearCart();
        return "redirect:/cartitem";
    }
}
