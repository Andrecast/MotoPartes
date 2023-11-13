package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.entity.Store;

import java.util.List;

public interface IStoreService {

    public Store getStoreById(Long storeId);
    public List<Store> getAllStores();
}
