package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dao.ITaxDao;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import com.tcgb02.motopartes.providermovement.models.entity.Tax;
import com.tcgb02.motopartes.providermovement.models.entity.TaxProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TaxServiceImpl implements ITaxService{

    @Autowired
    private ITaxDao taxDao;

    @Override
    public BigDecimal calculateTaxForProduct(Product product, Integer amount) {
        List<TaxProduct> taxProducts = product.getTaxes();
        BigDecimal totalTax = BigDecimal.ZERO;

        for (TaxProduct taxProduct : taxProducts) {
            Tax tax = taxProduct.getTax();
            BigDecimal taxRate = new BigDecimal(tax.getRate()).divide(new BigDecimal(100)); // Convertir el porcentaje a decimal
            BigDecimal productPrice = new BigDecimal(String.valueOf(product.getPrice()));
            BigDecimal taxAmount = productPrice.multiply(taxRate).multiply(new BigDecimal(amount));
            totalTax = totalTax.add(taxAmount);
        }

        return totalTax;
    }
}
