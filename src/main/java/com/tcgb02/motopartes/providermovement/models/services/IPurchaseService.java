package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dto.PurchaseDTO;

public interface IPurchaseService {

    void createPurchase(PurchaseDTO purchaseDTO);
}
