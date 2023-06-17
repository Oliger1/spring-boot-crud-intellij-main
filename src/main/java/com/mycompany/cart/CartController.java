package com.mycompany.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model) {
        Cart cart = new Cart();
        // Load cart items from database or session
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
        Cart cart = new Cart();
        // Load cart items from database or session
        cartService.addToCart(cart, cartItem);
        model.addAttribute("message", "Product added to cart successfully.");
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
        Cart cart = new Cart();
        // Load cart items from database or session
        cartService.removeFromCart(cart, cartItem);
        model.addAttribute("message", "Product removed from cart successfully.");
        return "redirect:/cart";
    }
}
