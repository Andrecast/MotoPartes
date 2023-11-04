package com.tcgb02.motopartes.commons.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="provider_movement", schema="APP_M_INVENTARIO")
public class ProviderMovement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "provider_movement_seq", sequenceName = "provider_movement_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_movement_seq")
    @Column(name = "provider_movement_id")
    public Long providerMovementId;

    //@Column(nullable = false)
    private Integer amount;

    @Column(name = "create_at") //@Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd") con prePeersist lo va hacer automático
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    //@Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providerId", insertable = false, updatable = false) //unidireccional
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", insertable = false, updatable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", insertable = false, updatable = false) //relación unidireccional
    private Product product;

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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
