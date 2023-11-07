package com.tcgb02.motopartes.commons.models.services;

import com.tcgb02.motopartes.commons.models.dao.IProviderMovementDao;
import com.tcgb02.motopartes.commons.models.dto.ProviderMovementDTO;
import com.tcgb02.motopartes.commons.models.entity.ProviderMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service //Para poder inyectar este bean en el controlador y poder utilizarlo
public class ProviderMovementServiceImpl implements IProviderMovementService{

    @Autowired
    private IProviderMovementDao providerMovementDao;
    @Override
    @Transactional(readOnly = true)
    public List<ProviderMovementDTO> findAllAsDTO() {
        List<ProviderMovement> providerMovements = (List<ProviderMovement>) providerMovementDao.findAll();

        List<ProviderMovementDTO> providerMovementDTOs = new ArrayList<>();

        for (ProviderMovement movement : providerMovements) {
            ProviderMovementDTO dto = new ProviderMovementDTO();
            dto.setAmount(movement.getAmount());
            dto.setCreateAt(movement.getCreateAt());
            dto.setStatus(movement.getStatus());

            // Obtener los nombres de las relaciones
            if (movement.getProduct() != null) {
                dto.setProductName(movement.getProduct().getName());
            }
            if (movement.getProvider() != null) {
                dto.setProviderName(movement.getProvider().getName());
            }
            if (movement.getStore() != null) {
                dto.setStoreName(movement.getStore().getName());
            }

            providerMovementDTOs.add(dto);
        }

        return providerMovementDTOs;
    }
}
