package com.Rokomari.inventoryservice.mapper;

import com.Rokomari.inventoryservice.dto.InventoryReqDto;
import com.Rokomari.inventoryservice.dto.InventoryResDto;
import com.Rokomari.inventoryservice.entity.InventoryEntity;

public class InventoryMapper {
    public  static InventoryEntity inventoryToEntity (InventoryReqDto inventoryReqDto){
        return InventoryEntity.builder()
                .inventoryId(inventoryReqDto.getInventoryId())
                .price(inventoryReqDto.getPrice())
                .quantity(inventoryReqDto.getQuantity())
                .build();
    }
    public  static InventoryResDto inventoryEntityToResDto (InventoryEntity inventoryEntity){
        return InventoryResDto.builder()
                .inventoryId(inventoryEntity.getInventoryId())
                .price(inventoryEntity.getPrice())
                .quantity(inventoryEntity.getQuantity())
                .build();
    }
}
