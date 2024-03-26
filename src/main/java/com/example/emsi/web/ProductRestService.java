package com.example.emsi.web;

import com.example.emsi.Entities.Product;
import com.example.emsi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestService {
    @Autowired //injection des dépendances

    private ProductRepository productRepository;
    @GetMapping("/products") //envoi requete http avec get vers /products
    public List<Product> products(){
        return productRepository.findAll();
    }

    @GetMapping("/products{id}") //envoi requete http avec get vers /products
    public Product findProducts(@PathVariable Long id ){
    Product product = productRepository.findById(id).orElse(null);
    return product;
    }
}
