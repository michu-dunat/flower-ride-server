package com.example.flowerrideserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Sender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @EqualsAndHashCode.Include
    @NotNull
    private String name;
    @NotNull
    @EqualsAndHashCode.Include
    private String lastName;
    @NotNull
    @EqualsAndHashCode.Include
    private String phoneNumber;
    @NotNull
    @EqualsAndHashCode.Include
    private String email;

    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<DeliveryOrder> deliveryOrder;

    public Sender(String name, String lastName, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
