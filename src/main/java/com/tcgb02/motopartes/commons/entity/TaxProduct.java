package com.tcgb02.motopartes.commons.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tax_product", schema="APP_M_INVENTARIO")
public class TaxProduct implements Serializable {


    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TaxProductPK id;

    @ManyToOne
    //@JoinColumn(name = "tax_id", insertable = false, updatable = false)
    private Tax tax;

    @ManyToOne
    //@JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public TaxProductPK getId() {
        return id;
    }

    public void setId(TaxProductPK id) {
        this.id = id;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
