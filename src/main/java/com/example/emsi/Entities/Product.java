package com.example.emsi.Entities;

import jakarta.persistence.Entity; //package JPA
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA
@Data //pour les getters & setters
@NoArgsConstructor @AllArgsConstructor

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // identifient entity 'JPA' product sinn souligner en rouge
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
