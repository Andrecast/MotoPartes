package com.tcgb02.motopartes.commons.models.services;

import com.tcgb02.motopartes.commons.models.dto.ProviderMovementDTO;

import java.util.List;

public interface IProviderMovementService {

    public List<ProviderMovementDTO> findAllAsDTO();
}
