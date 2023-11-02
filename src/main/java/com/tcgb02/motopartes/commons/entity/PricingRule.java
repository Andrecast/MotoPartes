package com.tcgb02.motopartes.commons.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pricing_rule", schema="APP_M_INVENTARIO")
public class PricingRule implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pricing_rule_seq", sequenceName = "pricing_rule_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricing_rule_seq")
    private Long pricing_rule_id;

    @Column(name = "base_price", nullable = false)
    private Long basePrice;

    @Column(nullable = false)
    private Long discount;

    @Column(name = "min_amount", nullable = false)
    private Integer minAmount;

    @Column(name = "max_amount", nullable = false)
    private Integer maxAmount;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public Long getPricing_rule_id() {
        return pricing_rule_id;
    }

    public void setPricing_rule_id(Long pricing_rule_id) {
        this.pricing_rule_id = pricing_rule_id;
    }

    public Long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Long basePrice) {
        this.basePrice = basePrice;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
