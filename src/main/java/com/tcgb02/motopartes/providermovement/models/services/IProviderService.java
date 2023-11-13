package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.entity.Provider;

import java.util.List;

public interface IProviderService {

    Provider getProviderById(Long providerId);

    List<Provider> getAllProviders();
}
