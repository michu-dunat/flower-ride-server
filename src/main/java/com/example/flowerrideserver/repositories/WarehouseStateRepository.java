package com.example.flowerrideserver.repositories;

import com.example.flowerrideserver.models.WarehouseState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseStateRepository extends JpaRepository<WarehouseState, Integer> {
}
