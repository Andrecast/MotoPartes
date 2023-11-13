package com.tcgb02.motopartes.providermovement.models.dto;

import java.util.Date;
import java.util.List;

public class ProviderMovementDTO {

    private Long providerMovementId;
    private Integer amount;
    private Date createAt;
    private String status;
    private String providerName;
    private String storeName;
    private String productName;

    public Long getProviderMovementId() {
        return providerMovementId;
    }

    public void setProviderMovementId(Long providerMovementId) {
        this.providerMovementId = providerMovementId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
