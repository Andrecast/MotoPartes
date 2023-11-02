package com.tcgb02.motopartes.commons.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="product", schema="APP_M_INVENTARIO")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long product_id;

    @Column(nullable = false)
    private String name;

    @Column(name = "alt_description")
    private String altDescription;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long price;

    @Column(name = "data_sheet")
    private String dataSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "provider_id", insertable = false, updatable = false)
    private Provider provider;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<TaxProduct> taxes;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Inventory> inventory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<PricingRule> pricingRule;

    //@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    //private List<ProviderMovement> providerMovement; movimientos que ha tenido un producto


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDataSheet() {
        return dataSheet;
    }

    public void setDataSheet(String dataSheet) {
        this.dataSheet = dataSheet;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<TaxProduct> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxProduct> taxes) {
        this.taxes = taxes;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public List<PricingRule> getPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(List<PricingRule> pricingRule) {
        this.pricingRule = pricingRule;
    }
}
