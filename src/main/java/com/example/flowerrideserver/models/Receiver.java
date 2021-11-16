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
public class Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastName;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String city;
    private String postcode;

    @OneToMany(mappedBy="receiver")
    private List<DeliveryOrder> deliveryOrder;

    public Receiver(String name, String lastName, String street, String buildingNumber, String apartmentNumber, String city, String postcode) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.postcode = postcode;
    }
}
