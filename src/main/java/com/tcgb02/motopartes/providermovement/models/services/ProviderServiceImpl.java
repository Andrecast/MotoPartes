package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dao.IProviderDao;
import com.tcgb02.motopartes.providermovement.models.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    private IProviderDao providerDao;

    @Override
    public Provider getProviderById(Long providerId) {
        return providerDao.findById(providerId).orElse(null);
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerDao.findAll();
    }
}
