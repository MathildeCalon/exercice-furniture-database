package com.example.exercice_furniture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id")
    private int id;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "furniture_id", referencedColumnName = "furniture_id")
    private Furniture furniture;
}
