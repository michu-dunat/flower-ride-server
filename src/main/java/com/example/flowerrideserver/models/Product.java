package com.example.flowerrideserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int howMany;
    @OneToOne
    private WarehouseState warehouseState;

    public Product(int howMany, WarehouseState warehouseState) {
        this.howMany = howMany;
        this.warehouseState = warehouseState;
    }
}
