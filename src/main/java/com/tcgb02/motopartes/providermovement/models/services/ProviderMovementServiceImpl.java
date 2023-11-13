package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dto.ProviderMovementDTO;
import com.tcgb02.motopartes.providermovement.models.entity.ProviderMovement;
import com.tcgb02.motopartes.providermovement.models.dao.IProviderMovementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Para poder inyectar este bean en el controlador y poder utilizarlo
public class ProviderMovementServiceImpl implements IProviderMovementService {

    @Autowired
    private IProviderMovementDao providerMovementDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProviderMovementDTO> findAllAsDTO() {
        List<ProviderMovement> providerMovements = (List<ProviderMovement>) providerMovementDao.findAll();

        List<ProviderMovementDTO> providerMovementDTOs = new ArrayList<>();

        for (ProviderMovement movement : providerMovements) {
            ProviderMovementDTO dto = new ProviderMovementDTO();
            dto.setProviderMovementId(movement.getProviderMovementId());
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

    @Override
    @Transactional(readOnly = true)
    public ProviderMovementDTO findById(Long id) {
        Optional<ProviderMovement> optionalProviderMovement = providerMovementDao.findById(id);

        if (optionalProviderMovement.isPresent()) {
            ProviderMovement movement = optionalProviderMovement.get();
            ProviderMovementDTO dto = new ProviderMovementDTO();
            dto.setProviderMovementId(movement.getProviderMovementId());
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

            return dto;
        } else {
            // Manejo de caso donde no se encuentra el ProviderMovement con el ID dado
            // Puedes lanzar una excepción o devolver un DTO vacío, dependiendo de tus necesidades
            return null;
        }
    }

}
