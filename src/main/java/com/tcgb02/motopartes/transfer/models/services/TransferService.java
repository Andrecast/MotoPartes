package com.tcgb02.motopartes.transfer.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransferService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransferService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void doTransfer(int productId, int amount, int store_origen_id, int store_destiny_id) {
        String procedureCall = "{call realizar_traspaso(?, ?, ?, ?)}";

        jdbcTemplate.update(procedureCall, productId, amount, store_origen_id, store_destiny_id);
    }
}
