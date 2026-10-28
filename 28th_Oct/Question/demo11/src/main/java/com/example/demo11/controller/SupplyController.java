
package com.example.demo11.controller;

import com.example.demo11.Supply;
import com.example.demo11.service.SupplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    public String addSupply(@RequestBody Supply supply) {
        supplyService.addOrRestockSupply(supply);
        return "Supply added or restocked successfully";
    }

    @GetMapping
    public List<Supply> getAllSupplies() {
        return supplyService.getAllSupplies();
    }
}
