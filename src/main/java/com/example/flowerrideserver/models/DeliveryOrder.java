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
public class DeliveryOrder {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Order_Product",
            joinColumns = {@JoinColumn(name = "delivery_order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    List<Product> products;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    private java.sql.Date deliveryDate;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Sender sender;
    @ManyToOne
    private Receiver receiver;

}
