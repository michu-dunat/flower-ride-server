package com.example.flowerrideserver.controllers;

import com.example.flowerrideserver.models.WarehouseState;
import com.example.flowerrideserver.repositories.WarehouseStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class AddWarehouseStateController {

    @Autowired
    private WarehouseStateRepository warehouseStateRepository;

    @PostMapping("/add-warehouse-state")
    public ResponseEntity<Integer> addWarehouseState(@RequestBody WarehouseState warehouseState) {
        System.out.println(warehouseState);
        warehouseStateRepository.save(warehouseState);
        return new ResponseEntity<>(200, HttpStatus.OK);
    }

}
