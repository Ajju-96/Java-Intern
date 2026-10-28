
package com.example.demo11.repository;

import com.example.demo11.SupplyRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveRequest(SupplyRequest request) {
        String sql = """
                INSERT INTO requests
                    (item_name, quantity, status, requested_by)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                request.getItemName(),
                request.getQuantity(),
                request.getStatus(),
                request.getRequestedBy()
        );
    }
}
