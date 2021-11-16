package com.example.flowerrideserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WarehouseState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int pricePerPiece;
    private int amount;
    private boolean isFlower;
    @OneToOne(mappedBy="warehouseState")
    private Product product;

    public WarehouseState(String name, int pricePerPiece, int amount, boolean isFlower) {
        this.name = name;
        this.pricePerPiece = pricePerPiece;
        this.amount = amount;
        this.isFlower = isFlower;
    }
}
