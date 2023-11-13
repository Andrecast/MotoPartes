package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dao.IPricingRuleDao;
import com.tcgb02.motopartes.providermovement.models.entity.PricingRule;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PricingRuleServiceImpl implements IPricingRuleService {

    @Autowired
    private IPricingRuleDao pricingRuleDao;

    @Override
    public BigDecimal applyPricingRule(Product product, Integer amount) {
        List<PricingRule> applicableRules = pricingRuleDao.findApplicableRules(product, amount, new Date());

        if (!applicableRules.isEmpty()) {
            PricingRule applicableRule = applicableRules.get(0);
            BigDecimal originalPrice = product.getPrice();
            BigDecimal discount = pricingRuleDao.findDiscountByRule(applicableRule);

            // Aplicar el descuento al precio original
            return originalPrice.multiply(BigDecimal.ONE.subtract(discount)).multiply(new BigDecimal(amount));
        }

        // Si no hay regla de precio aplicable, devolver el precio original
        return product.getPrice().multiply(new BigDecimal(amount));
    }

}
