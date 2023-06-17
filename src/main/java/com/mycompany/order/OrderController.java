package com.mycompany.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order_form";
    }

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute("order") Order order) {
        orderService.placeOrder(order);
        return "redirect:/orders";
    }

    // Other methods for order management
}
