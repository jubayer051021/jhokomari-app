package com.Rokomari.inventoryservice.service.Imp;

import com.Rokomari.inventoryservice.dto.InventoryReqDto;
import com.Rokomari.inventoryservice.dto.InventoryResDto;
import com.Rokomari.inventoryservice.entity.InventoryEntity;
import com.Rokomari.inventoryservice.exception.InventoryAlreadyExistException;
import com.Rokomari.inventoryservice.exception.InventoryNotFoundException;
import com.Rokomari.inventoryservice.mapper.InventoryMapper;
import com.Rokomari.inventoryservice.repository.InventoryRepository;
import com.Rokomari.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImp implements InventoryService{
    private final InventoryRepository inventoryRepository;

    @Override
    public ResponseEntity<List<InventoryResDto>> getAllInventory() {
        List<InventoryEntity> invrntoryList=inventoryRepository.findAll();
        List<InventoryResDto> inventoryResList=invrntoryList.stream().map(InventoryMapper::inventoryEntityToResDto).toList();
        return new ResponseEntity<>(inventoryResList,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> createInventory(InventoryReqDto inventoryReqDto) {
        InventoryEntity existInventory=inventoryRepository.findByInventoryId(inventoryReqDto.getInventoryId());
        if(existInventory!=null){
            throw new InventoryAlreadyExistException("Inventory Already exist.. please insert new Inventory");
        }
        InventoryEntity newInventory= InventoryMapper.inventoryToEntity(inventoryReqDto);
        inventoryRepository.save(newInventory);
        return new ResponseEntity<>("Successfully inventory created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateInventory(Long bookId,InventoryReqDto inventoryReqDto) {
        InventoryEntity existInventory=inventoryRepository.findByInventoryId(bookId);
        if(existInventory==null){
            throw new InventoryNotFoundException("Inventory Could not found for update");
        }
        existInventory.setQuantity(inventoryReqDto.getQuantity());
        existInventory.setQuantity(inventoryReqDto.getQuantity());
        inventoryRepository.save(existInventory);
        return new ResponseEntity<>("Successfully inventory updated", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<InventoryResDto> inventoryDetails(Long bookId) {
        InventoryEntity existInventory=inventoryRepository.findByInventoryId(bookId);
        if (existInventory==null){
            throw new InventoryNotFoundException("Inventory Could Not Found");
        }
        InventoryResDto responseInventory=InventoryMapper.inventoryEntityToResDto(existInventory);
        return new ResponseEntity<>(responseInventory,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteInventory(Long bookId) {
        InventoryEntity existInventory=inventoryRepository.findByInventoryId(bookId);
        if (existInventory==null){
            throw new InventoryNotFoundException("Inventory Could Not Found for delete");
        }
        inventoryRepository.delete(existInventory);
        return new ResponseEntity<>("SuccessFully deleted Inventory",HttpStatus.OK);
    }
}
