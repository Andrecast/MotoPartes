package com.tcgb02.motopartes.providermovement.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="pricing_rule", schema="APP_M_INVENTARIO")
public class PricingRule implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pricing_rule_seq", sequenceName = "pricing_rule_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricing_rule_seq")
    @Column(name = "pricing_rule_id")
    private Long pricingRuleId;

    @Column(name = "base_price")
    private Long basePrice;

    //@Column(nullable = false)
    private BigDecimal discount;

    @Column(name = "min_amount")
    private Integer minAmount;

    @Column(name = "max_amount")
    private Integer maxAmount;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date") //@Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

    public Long getPricingRuleId() {
        return pricingRuleId;
    }

    public void setPricingRuleId(Long pricingRuleId) {
        this.pricingRuleId = pricingRuleId;
    }

    public Long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Long basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
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
