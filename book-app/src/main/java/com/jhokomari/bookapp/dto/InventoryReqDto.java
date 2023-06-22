package com.jhokomari.bookapp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryReqDto {
    private Long inventoryId;
    private Integer quantity;
    private Double price;
}
