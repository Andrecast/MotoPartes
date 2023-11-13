package com.tcgb02.motopartes.providermovement.models.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {
    private Long productId;

    private BigDecimal amount;
    private String name;
    private BigDecimal price;
    private List<Long> taxIds;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Long> getTaxIds() {
        return taxIds;
    }

    public void setTaxIds(List<Long> taxIds) {
        this.taxIds = taxIds;
    }
}
