package com.Rokomari.inventoryservice.service;

import com.Rokomari.inventoryservice.dto.InventoryReqDto;
import com.Rokomari.inventoryservice.dto.InventoryResDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InventoryService {
    ResponseEntity<String> createInventory(InventoryReqDto inventoryReqDto);

    ResponseEntity<String> updateInventory(Long bookId,InventoryReqDto inventoryReqDto);

    ResponseEntity<InventoryResDto> inventoryDetails(Long bookId);

    ResponseEntity<String> deleteInventory(Long bookId);

    ResponseEntity<List<InventoryResDto>> getAllInventory();
}
