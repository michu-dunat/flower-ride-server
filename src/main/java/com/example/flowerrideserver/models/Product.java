package com.example.flowerrideserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(mappedBy = "products")
    private List<DeliveryOrder> deliveryOrders;

    public Product(int howMany, WarehouseState warehouseState) {
        this.howMany = howMany;
        this.warehouseState = warehouseState;
    }
}
