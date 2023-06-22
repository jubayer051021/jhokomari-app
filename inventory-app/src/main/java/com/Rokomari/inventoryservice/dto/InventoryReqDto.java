package com.Rokomari.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryReqDto {
    private Long inventoryId;
    private Integer quantity;
    private Double price;
}
