package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dto.ProviderMovementDTO;

import java.util.List;

public interface IProviderMovementService {

    public List<ProviderMovementDTO> findAllAsDTO();

    public ProviderMovementDTO findById(Long id);


}
