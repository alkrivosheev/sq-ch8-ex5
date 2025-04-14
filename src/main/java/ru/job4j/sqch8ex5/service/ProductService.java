package ru.job4j.sqch8ex5.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.job4j.sqch8ex5.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
}
