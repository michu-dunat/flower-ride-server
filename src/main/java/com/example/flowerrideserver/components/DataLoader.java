package com.example.flowerrideserver.components;

import com.example.flowerrideserver.models.WarehouseState;
import com.example.flowerrideserver.repositories.WarehouseStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private WarehouseStateRepository warehouseStateRepository;

    public void run(ApplicationArguments args) {
        warehouseStateRepository.save(new WarehouseState("Tulipan", 2, 10, true));
        warehouseStateRepository.save(new WarehouseState("Róża", 2, 5, true));
        warehouseStateRepository.save(new WarehouseState("Wstążka", 1, 100, false));
    }
}
