package com.tcgb02.motopartes.commons.entity;

import javax.persistence.*;

@Entity
@Table(name="inventory", schema="APP_M_INVENTARIO")
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventory_seq", sequenceName = "inventory_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
    private Long inventory_id;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer available;

    @Column(name = "min_quantity", nullable = false)
    private Integer minQuantity;

    @Column(name = "max_quantity", nullable = false)
    private Integer maxQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
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
