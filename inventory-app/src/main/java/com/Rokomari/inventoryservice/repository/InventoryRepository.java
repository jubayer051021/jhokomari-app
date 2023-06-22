package com.Rokomari.inventoryservice.repository;

import com.Rokomari.inventoryservice.dto.InventoryReqDto;
import com.Rokomari.inventoryservice.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
    InventoryEntity findByInventoryId( Long inventoryId);
}
