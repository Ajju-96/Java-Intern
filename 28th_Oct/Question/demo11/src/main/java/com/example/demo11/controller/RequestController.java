
package com.example.demo11.controller;

import com.example.demo11.SupplyRequest;
import com.example.demo11.service.RequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public SupplyRequest createRequest(
            @RequestBody SupplyRequest request) {

        return requestService.allocateSupply(request);
    }
}
