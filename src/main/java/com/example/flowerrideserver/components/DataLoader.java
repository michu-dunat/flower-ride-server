package com.example.flowerrideserver.components;

import com.example.flowerrideserver.models.*;
import com.example.flowerrideserver.repositories.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final WarehouseStateRepository warehouseStateRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final SenderRepository senderRepository;
    private final ReceiverRepository receiverRepository;
    private final DeliveryOrderRepository deliveryOrderRepository;

    public void run(ApplicationArguments args) {
        warehouseStateRepository.save(new WarehouseState("Tulip", 2, 10, true));
        warehouseStateRepository.save(new WarehouseState("Freesia", 3, 20, true));
        warehouseStateRepository.save(new WarehouseState("Lily", 4, 33, true));
        warehouseStateRepository.save(new WarehouseState("Gillyflower", 5, 34, true));
        warehouseStateRepository.save(new WarehouseState("Gerbera", 4, 45, true));
        warehouseStateRepository.save(new WarehouseState("Daisy", 3, 56, true));
        WarehouseState rose = new WarehouseState("Rose", 2, 50, true);
        warehouseStateRepository.save(rose);
        WarehouseState ribbon = new WarehouseState("Ribbon", 1, 10, false);
        warehouseStateRepository.save(ribbon);
        warehouseStateRepository.save(new WarehouseState("Card with wishes", 10, 100, false));
        warehouseStateRepository.save(new WarehouseState("Voucher", 100, 5, false));
        userRepository.save(new User("adminadmin", DigestUtils.sha256Hex("adminadmin"), "ROLE_ADMIN"));
        userRepository.save(new User("useruser", DigestUtils.sha256Hex("useruser"), "ROLE_USER"));
        statusRepository.save(new Status(1, "Order placed"));
        Status paid = new Status(2, "Order paid");
        statusRepository.save(paid);
        Sender sender = new Sender("Janek", "P", "666256533", "jp@gmail.com");
        senderRepository.save(sender);
        Receiver receiver = new Receiver("Martyna", "M", "Sadowa", "13", "10", "Katowice", "01-420");
        receiverRepository.save(receiver);
        Product product = new Product(10, rose);
        Product product1 = new Product(1, ribbon);
        List<Product> products = Arrays.asList(product, product1);
        Date date = new Date(System.currentTimeMillis());
        DeliveryOrder deliveryOrder = new DeliveryOrder(21, date, paid, sender, receiver);
        deliveryOrder.setProducts(products);
        deliveryOrderRepository.save(deliveryOrder);
    }
}