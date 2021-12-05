package com.example.flowerrideserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private Boolean isFlower;
    @OneToMany(mappedBy = "warehouseState")
    @JsonIgnore
    private Set<Product> products;

    public WarehouseState(String name, int pricePerPiece, int amount, boolean isFlower) {
        this.name = name;
        this.pricePerPiece = pricePerPiece;
        this.amount = amount;
        this.isFlower = isFlower;
    }
}
