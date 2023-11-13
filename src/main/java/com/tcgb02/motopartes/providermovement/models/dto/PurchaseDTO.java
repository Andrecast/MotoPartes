package com.tcgb02.motopartes.providermovement.models.dto;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseDTO {

    private List<Long> productIds;
    private List<Integer> amounts;
    private List<BigDecimal> prices;
    private Long storeId;

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<Integer> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Integer> amounts) {
        this.amounts = amounts;
    }

    public List<BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(List<BigDecimal> prices) {
        this.prices = prices;
    }
}
