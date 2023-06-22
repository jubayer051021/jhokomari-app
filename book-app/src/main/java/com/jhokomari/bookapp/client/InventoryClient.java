package com.jhokomari.bookapp.client;

import com.jhokomari.bookapp.dto.InventoryReqDto;
import com.jhokomari.bookapp.dto.InventoryResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange
public interface InventoryClient {
    @PostExchange("/inventory")
    public ResponseEntity<String> createInventory(@RequestBody InventoryReqDto inventoryReqDto);
    @GetExchange("/inventory")
    public ResponseEntity<List<InventoryResDto>> getAllInventory();
    @PutExchange("/inventory/{bookId}")
    public ResponseEntity<String> updateInventory(@PathVariable("bookId") Long bookId, @RequestBody InventoryReqDto inventoryReqDto);

    @GetExchange ("/inventory/{bookId}")
    public ResponseEntity<InventoryResDto> inventoryDetails(@PathVariable("bookId") Long bookId);

    @DeleteExchange("/inventory/{bookId}")
    public ResponseEntity<String> deleteInventory(@PathVariable("bookId") Long bookId);

}
