package com.mycompany.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // Other methods for cart management
}
