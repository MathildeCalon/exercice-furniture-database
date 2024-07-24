package com.example.exercice_furniture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furniture_id")
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;

    @ManyToOne
    @JoinColumn(name="cartItem_id")
    private CartItem cartItem;
}
