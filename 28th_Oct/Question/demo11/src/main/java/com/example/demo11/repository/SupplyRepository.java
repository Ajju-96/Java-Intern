
package com.example.demo11.repository;

import com.example.demo11.Supply;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Convert each database row into a Supply object
    private final RowMapper<Supply> supplyRowMapper = (rs, rowNum) ->
            new Supply(
                    rs.getLong("id"),
                    rs.getString("item_name"),
                    rs.getInt("quantity")
            );

    // Add a new supply or restock an existing one
    public void addOrRestockSupply(Supply supply) {

        // First, try to increase the existing stock
        String updateSql = """
                UPDATE supplies
                SET quantity = quantity + ?
                WHERE item_name = ?
                """;

        int rowsUpdated = jdbcTemplate.update(
                updateSql,
                supply.getQuantity(),
                supply.getItemName()
        );

        // If the item does not exist, insert a new record
        if (rowsUpdated == 0) {

            String insertSql = """
                    INSERT INTO supplies (item_name, quantity)
                    VALUES (?, ?)
                    """;

            jdbcTemplate.update(
                    insertSql,
                    supply.getItemName(),
                    supply.getQuantity()
            );
        }
    }

    // Retrieve all available supplies
    public List<Supply> getAllSupplies() {

        String sql = """
                SELECT id, item_name, quantity
                FROM supplies
                ORDER BY id
                """;

        return jdbcTemplate.query(sql, supplyRowMapper);
    }
}
