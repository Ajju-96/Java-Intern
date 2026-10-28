
package com.example.demo11.service;

import com.example.demo11.SupplyRequest;
import com.example.demo11.repository.RequestRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {

    private final JdbcTemplate jdbcTemplate;
    private final RequestRepository requestRepository;

    public RequestService(
            JdbcTemplate jdbcTemplate,
            RequestRepository requestRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.requestRepository = requestRepository;
    }

    @Transactional
    public SupplyRequest allocateSupply(SupplyRequest request) {

        // Validate request data
        if (request.getItemName() == null ||
                request.getItemName().isBlank()) {
            throw new IllegalArgumentException(
                    "Item name is required"
            );
        }

        if (request.getRequestedBy() == null ||
                request.getRequestedBy().isBlank()) {
            throw new IllegalArgumentException(
                    "Requested by is required"
            );
        }

        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        // Deduct stock only if sufficient quantity is available
        String updateSql = """
                UPDATE supplies
                SET quantity = quantity - ?
                WHERE item_name = ?
                  AND quantity >= ?
                """;

        int rowsUpdated = jdbcTemplate.update(
                updateSql,
                request.getQuantity(),
                request.getItemName(),
                request.getQuantity()
        );

        // Zero updated rows means item is missing or stock is insufficient
        if (rowsUpdated == 0) {
            throw new IllegalArgumentException(
                    "Supply not found or insufficient stock"
            );
        }

        // Record the successful allocation
        request.setStatus("APPROVED");
        requestRepository.saveRequest(request);

        return request;
    }
}
