package com.tcgb02.motopartes.providermovement.models.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EndPurchaseDTO {

    private Long providerMovementId;
    private Integer amount;
    private Date createAt;
    private String status;
    private Long providerId;
    private Long storeId;
    private Long productId;

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

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
