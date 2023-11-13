package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.entity.Product;

import java.math.BigDecimal;

public interface ITaxService {
    BigDecimal calculateTaxForProduct(Product product, Integer amount);
}
