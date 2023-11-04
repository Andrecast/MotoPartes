package com.tcgb02.motopartes.commons.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tax", schema="APP_M_INVENTARIO")
public class Tax implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tax_seq", sequenceName = "tax_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_seq")
    @Column(name = "tax_id")
    private Long taxId;

    //@Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    private Long rate;

    //@Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "tax", fetch = FetchType.LAZY)
    private List<TaxProduct> products;

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaxProduct> getProducts() {
        return products;
    }

    public void setProducts(List<TaxProduct> products) {
        this.products = products;
    }
}
