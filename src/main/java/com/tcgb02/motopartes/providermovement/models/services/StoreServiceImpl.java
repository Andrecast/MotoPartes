package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dao.IStoreDao;
import com.tcgb02.motopartes.providermovement.models.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService{

    @Autowired
    private IStoreDao storeDao;

    @Override
    public Store getStoreById(Long storeId) {
        return storeDao.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + storeId));
    }

    @Override
    public List<Store> getAllStores() {
        return storeDao.findAll();
    }

}
