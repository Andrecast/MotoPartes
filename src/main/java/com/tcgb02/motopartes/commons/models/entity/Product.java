package com.tcgb02.motopartes.commons.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @Column(name = "product_id")
    private Long productId;

    //@Column(nullable = false)
    private String name;

    @Column(name = "alt_description")
    private String altDescription;

    //@Column(nullable = false)
    private String description;

    //@Column(nullable = false)
    private Long price;

    @Column(name = "data_sheet")
    private String dataSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providerId", insertable = false, updatable = false)
    @JsonBackReference
    private Provider provider;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TaxProduct> taxes;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Inventory> inventory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PricingRule> pricingRule;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProviderMovement> providerMovement;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<ProviderMovement> getProviderMovement() {
        return providerMovement;
    }

    public void setProviderMovement(List<ProviderMovement> providerMovement) {
        this.providerMovement = providerMovement;
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
