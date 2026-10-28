
package com.example.demo11.service;

import com.example.demo11.Supply;
import com.example.demo11.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public void addOrRestockSupply(Supply supply) {

        if (supply.getItemName() == null ||
                supply.getItemName().isBlank()) {
            throw new IllegalArgumentException(
                    "Item name is required"
            );
        }

        if (supply.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        supplyRepository.addOrRestockSupply(supply);
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.getAllSupplies();
    }
}
