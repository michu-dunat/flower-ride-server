package com.example.flowerrideserver.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String type;

    @OneToMany(mappedBy="status")
    private List<DeliveryOrder> deliveryOrder;

    public Status(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Status(String type) {
        this.type = type;
    }
}
