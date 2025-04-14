package ru.job4j.sqch8ex5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.sqch8ex5.model.Product;
import ru.job4j.sqch8ex5.service.ProductService;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            /* Код ниже можно и не писать т.к. Spring может и сам сопоставить
            @RequestParam String name,
            @RequestParam double price, */
            Product p,
            Model model
            ) {
/*    Код ниже можно и не писать т.к. Spring может и сам сопоставить
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);*/
        productService.addProduct(p);
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

}
