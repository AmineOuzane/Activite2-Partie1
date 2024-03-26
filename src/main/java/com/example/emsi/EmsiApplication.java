package com.example.emsi;

import com.example.emsi.Entities.Product;
import com.example.emsi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmsiApplication implements CommandLineRunner  { //pour executer le code apres demerage du  spring
   @Autowired // injection des dependence pdtrepos
    private ProductRepository productRepository; //use interface pour ajouter produit dans BD
    public static void main(String[] args) {

        SpringApplication.run(EmsiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3)); //null car id autoincrement
        productRepository.save(new Product(null,"Printer",4300,3)) ;//null car id autoincrement
        productRepository.save(new Product(null,"Smartphone",4300,3)); //null car id autoincrement
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString()); //string automatic generer par springdata
        });
       Product product=productRepository.findById(Long.valueOf(1)).get(); // chercher par ID
        System.out.println("**********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("**********");
        List<Product> productList = productRepository.search("%C%"); //keyword
        products.forEach(p->{
            System.out.println(p);
        });


    }
}
