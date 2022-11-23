package com.example.flowerrideserver.components;

import com.example.flowerrideserver.models.Status;
import com.example.flowerrideserver.models.User;
import com.example.flowerrideserver.models.WarehouseState;
import com.example.flowerrideserver.repositories.StatusRepository;
import com.example.flowerrideserver.repositories.UserRepository;
import com.example.flowerrideserver.repositories.WarehouseStateRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private WarehouseStateRepository warehouseStateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    public void run(ApplicationArguments args) {
        warehouseStateRepository.save(new WarehouseState("Tulip", 2, 10, true));
        warehouseStateRepository.save(new WarehouseState("Rose", 2, 5, true));
        warehouseStateRepository.save(new WarehouseState("Ribbon", 1, 100, false));
        userRepository.save(new User("adminadmin", DigestUtils.sha256Hex("adminadmin"), "ROLE_ADMIN"));
        userRepository.save(new User("useruser", DigestUtils.sha256Hex("useruser"), "ROLE_USER"));
        statusRepository.save(new Status(1, "Order placed"));
        statusRepository.save(new Status(2, "Order paid"));
    }
}