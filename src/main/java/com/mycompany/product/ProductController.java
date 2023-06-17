package com.mycompany.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String showProductList(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "product_list";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable("id") Integer id, Model model) {
        try {
            Product product = productService.getProductById(id);
            model.addAttribute("product", product);
            return "product_details";
        } catch (ProductNotFoundException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        Model product = model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model) {
        try {
            productService.deleteProduct(id);
            return "redirect:/products";
        } catch (ProductNotFoundException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}

