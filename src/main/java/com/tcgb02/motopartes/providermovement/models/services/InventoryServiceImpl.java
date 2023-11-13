package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dao.IInventoryDao;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import com.tcgb02.motopartes.providermovement.models.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private IInventoryDao inventoryDao;

    @Override
    public void updateInventoryAfterPurchase(Product product, Store store, Integer purchasedAmount) {
        inventoryDao.updateInventoryIfExists(purchasedAmount, product, store);
        inventoryDao.insertIntoInventoryIfNotExists(purchasedAmount, product, store);
    }
}
