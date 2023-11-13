package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dto.EndPurchaseDTO;
import com.tcgb02.motopartes.providermovement.models.dto.PurchaseDTO;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import com.tcgb02.motopartes.providermovement.models.entity.Provider;
import com.tcgb02.motopartes.providermovement.models.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private EndPurchaseDTO endPurchaseDTO;

    @Autowired
    private IEndPurchaseService endPurchaseService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IStoreService storeService;

    @Autowired
    private ITaxService taxService;

    @Autowired
    private IPricingRuleService pricingRuleService;

    @Autowired
    private IInventoryService inventoryService;


    @Override
    @Transactional
    public void createPurchase(PurchaseDTO purchaseDTO) {

        Store store = storeService.getStoreById(purchaseDTO.getStoreId());
        if (store == null) {
            throw new RuntimeException("No se pudo encontrar el producto con ID: " + purchaseDTO.getStoreId());
        }

        // Variables para el total de la compra
        Integer totalAmount = 0;
        BigDecimal totalTax = BigDecimal.ZERO;

        for (int i = 0; i < purchaseDTO.getProductIds().size(); i++) {
            Long productId = purchaseDTO.getProductIds().get(i);
            Integer amount = purchaseDTO.getAmounts().get(i);

            // Obtener el producto
            Product product = productService.getProductById(productId);
            if (product == null) {
                throw new RuntimeException("No se pudo encontrar el producto con ID: " + productId);
            }

            // Calcular impuestos para el producto actual
            BigDecimal taxes = taxService.calculateTaxForProduct(product, amount);

            // Aplicar reglas de precio para el producto actual
            BigDecimal discountedPrice = pricingRuleService.applyPricingRule(product, amount);

            // Si no hay regla de precio aplicable, utilizar el precio original
            if (discountedPrice == null) {
                discountedPrice = product.getPrice().multiply(new BigDecimal(amount));
            }

            // Calcular el subtotal para el producto actual
            BigDecimal subtotal = discountedPrice.add(taxes);

            // Actualizar el total de la compra
            // Convertir totalAmount a BigDecimal antes de realizar la operación
            BigDecimal totalAmountAsBigDecimal = new BigDecimal(totalAmount);
            totalAmountAsBigDecimal = totalAmountAsBigDecimal.add(subtotal);
            // Convertir totalAmount de vuelta a Integer
            totalAmount = totalAmountAsBigDecimal.intValue();
            totalTax = totalTax.add(taxes);

            Provider provider = product.getProvider();

            endPurchaseService.saveEndPurchase(endPurchaseDTO);

            // Actualizar inventario para cada producto
            inventoryService.updateInventoryAfterPurchase(product, store, amount);
        }
    }
}