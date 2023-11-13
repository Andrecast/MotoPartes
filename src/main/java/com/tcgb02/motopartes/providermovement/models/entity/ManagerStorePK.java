package com.tcgb02.motopartes.providermovement.models.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ManagerStorePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "store_id")
    private Long storeId;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
