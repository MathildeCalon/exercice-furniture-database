package com.example.exercice_furniture.service;

import com.example.exercice_furniture.dao.CartItemRepository;
import com.example.exercice_furniture.entity.CartItem;
import com.example.exercice_furniture.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final FurnitureService furnitureService;
    private CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    public CartItem addToCart(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public void removeFromCart(CartItem cartItem){
        Furniture furniture = cartItemRepository.findById(cartItem.getId()).get().getFurniture();
        furnitureService.increaseStock(furniture, cartItem.getQuantity());
        cartItemRepository.delete(cartItem);
    }

    public void clearCart(){
        cartItemRepository.deleteAll();
    }
}
