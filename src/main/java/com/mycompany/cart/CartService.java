package com.mycompany.cart;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    public void addToCart(Cart cart, CartItem cartItem) {
        cart.addCartItem(cartItem);
    }

    public void removeFromCart(Cart cart, CartItem cartItem) {
        cart.removeCartItem(cartItem);
    }

    // Other methods for cart management
}

