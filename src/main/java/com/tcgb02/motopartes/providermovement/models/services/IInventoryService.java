package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.entity.Product;
import com.tcgb02.motopartes.providermovement.models.entity.Store;

public interface IInventoryService {
    void updateInventoryAfterPurchase(Product product, Store store, Integer purchasedAmount);
}
