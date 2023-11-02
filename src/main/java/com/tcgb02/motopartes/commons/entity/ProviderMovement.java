package com.tcgb02.motopartes.commons.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="provider_movement", schema="APP_M_INVENTARIO")
public class ProviderMovement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "provider_movement_seq", sequenceName = "provider_movement_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_movement_seq")
    private Long provider_movement_id;

    @Column(nullable = false)
    private String amount;

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
    @JoinColumn(name = "provider_id", insertable = false, updatable = false) //Aquí si va el join por ser unidireccional
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id", insertable = false, updatable = false) //relación unidireccional
    //private Product product;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false) //relación unidireccional
    private List<Product> products;

    public ProviderMovement() {
        this.products = new ArrayList<Product>();
    }

    public Long getProvider_movement_id() {
        return provider_movement_id;
    }

    public void setProvider_movement_id(Long provider_movement_id) {
        this.provider_movement_id = provider_movement_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public void addProductMovement(Product product) {
        this.products.add(product);
    }

    //public Long calcularPrecio() {
      //  return amount; //Aquí hacer los calculos con taxes y reglas de precio
    //}
}
