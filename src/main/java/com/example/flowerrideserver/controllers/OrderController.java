package com.example.flowerrideserver.controllers;

import com.example.flowerrideserver.models.DeliveryOrder;
import com.example.flowerrideserver.models.Product;
import com.example.flowerrideserver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    ReceiverRepository receiverRepository;

    @Autowired
    SenderRepository senderRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WarehouseStateRepository warehouseStateRepository;

    @PostMapping("/make-order")
    public ResponseEntity<Integer> makeOrder(@RequestBody DeliveryOrder deliveryOrder) {
        try {
            boolean limitExceeded = false;
            //Sprawdzanie, czy nie wyszło poza limit składników w magazynie
            for (Product product : deliveryOrder.getProducts()) {
                if (warehouseStateRepository.getById(product.getWarehouseState().getId()).getAmount() < product.getHowMany())
                    limitExceeded = true;
            }

            if (limitExceeded)
                return new ResponseEntity<>(409, HttpStatus.CONFLICT);
            else {
                //Aktualizacja limitów w magazynie
                for (Product p : deliveryOrder.getProducts()) {
                    var newWarehouseState = warehouseStateRepository.getById(p.getWarehouseState().getId());
                    newWarehouseState.setAmount(newWarehouseState.getAmount() - p.getHowMany());
                    warehouseStateRepository.save(newWarehouseState);
                }

                //tutaj można sprawdzać czy taki receiver i sender już jest w bazie danych

                receiverRepository.save(deliveryOrder.getReceiver());
                senderRepository.save(deliveryOrder.getSender());
                deliveryOrder.setStatus(statusRepository.getById(1));
                productRepository.saveAll(deliveryOrder.getProducts());
                deliveryOrderRepository.save(deliveryOrder);
                return new ResponseEntity<>(deliveryOrder.getId(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(500, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/pay")
    public ResponseEntity<Integer> payForOrder(@RequestParam int orderId){
       try{
           var newOrder = deliveryOrderRepository.getById(orderId);
           newOrder.setStatus(statusRepository.getById(2));
           deliveryOrderRepository.save(newOrder);
           return new ResponseEntity<>(200, HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(500, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
