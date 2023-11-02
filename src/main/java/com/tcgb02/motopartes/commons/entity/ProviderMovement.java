package com.tcgb02.motopartes.commons.entity;

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
    private Long provider_movement_id;

    @Column(nullable = false)
    private Integer amount;

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd") con prePeersist lo va hacer automático
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", insertable = false, updatable = false) //unidireccional
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id", insertable = false, updatable = false) //relación unidireccional
    private Product product;


    public Long getProvider_movement_id() {
        return provider_movement_id;
    }

    public void setProvider_movement_id(Long provider_movement_id) {
        this.provider_movement_id = provider_movement_id;
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
