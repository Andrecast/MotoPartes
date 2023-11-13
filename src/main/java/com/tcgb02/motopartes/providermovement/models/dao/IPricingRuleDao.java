package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.PricingRule;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IPricingRuleDao extends JpaRepository<PricingRule, Long> {

    @Query("SELECT pr FROM PricingRule pr WHERE pr.product = :product AND :amount BETWEEN pr.minAmount AND pr.maxAmount " +
            "AND :currentDate BETWEEN pr.startDate AND pr.endDate")
    //findApplicableRules busca reglas aplicables para un producto dado, una cantidad y una fecha específica
    List<PricingRule> findApplicableRules(@Param("product") Product product,
                                          @Param("amount") Integer amount,
                                          @Param("currentDate") Date currentDate);

    @Query("SELECT pr.discount FROM PricingRule pr WHERE pr = :pricingRule")
    //findDiscountByRule obtiene el descuento asociado a una regla de precio
    BigDecimal findDiscountByRule(@Param("pricingRule") PricingRule pricingRule);
}
