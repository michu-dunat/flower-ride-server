package com.example.flowerrideserver.repositories;

import com.example.flowerrideserver.models.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Integer> {
}
