package com.tcgb02.motopartes.providermovement.models.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TaxProductPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "tax_id")
    private Long taxId;

    @Column(name = "product_id")
    private Long productId;

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
