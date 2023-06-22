package com.Rokomari.inventoryservice.controller;

import com.Rokomari.inventoryservice.dto.InventoryReqDto;
import com.Rokomari.inventoryservice.dto.InventoryResDto;
import com.Rokomari.inventoryservice.service.Imp.InventoryServiceImp;
import com.Rokomari.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping
    public ResponseEntity<List<InventoryResDto>> getAllInventory(){
        return inventoryService.getAllInventory();
    }
    @PostMapping
    public ResponseEntity<String> createInventory(@RequestBody InventoryReqDto inventoryReqDto){
        return inventoryService.createInventory(inventoryReqDto);
    }
    @PutMapping("/{bookId}")
    public ResponseEntity<String> updateInventory(@PathVariable("bookId") Long bookId,@RequestBody InventoryReqDto inventoryReqDto){
        return inventoryService.updateInventory(bookId,inventoryReqDto);
    }
    @GetMapping ("/{bookId}")
    public ResponseEntity<InventoryResDto> inventoryDetails(@PathVariable("bookId") Long bookId){
        return inventoryService.inventoryDetails(bookId);
    }
    @DeleteMapping ("/{bookId}")
    public ResponseEntity<String> deleteInventory(@PathVariable("bookId") Long bookId){
        return inventoryService.deleteInventory(bookId);
    }
}
