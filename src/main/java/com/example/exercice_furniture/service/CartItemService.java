package com.example.exercice_furniture.service;

import com.example.exercice_furniture.dao.CartItemRepository;
import com.example.exercice_furniture.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    public CartItem addToCart(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public void removeFromCartI(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }

    public void clearCart(){
        cartItemRepository.deleteAll();
    }
}
