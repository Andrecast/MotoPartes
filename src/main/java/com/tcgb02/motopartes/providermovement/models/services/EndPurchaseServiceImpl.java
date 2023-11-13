package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.models.dao.*;
import com.tcgb02.motopartes.providermovement.models.dto.EndPurchaseDTO;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import com.tcgb02.motopartes.providermovement.models.entity.Provider;
import com.tcgb02.motopartes.providermovement.models.entity.ProviderMovement;
import com.tcgb02.motopartes.providermovement.models.entity.Store;
import com.tcgb02.motopartes.providermovement.models.dao.IProviderMovementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EndPurchaseServiceImpl implements IEndPurchaseService {

    @Autowired
    private EndPurchaseDTO endPurchaseDTO;

    @Autowired
    private IProviderMovementDao providerMovementDao;

    @Autowired
    private IProviderService providerService;

    @Autowired
    private IStoreService storeService;

    @Autowired
    private IProductService productService;

    @Override
    //Método para almacenar los datos de la compra en ProviderMovement
    @Transactional
    public void saveEndPurchase(EndPurchaseDTO endPurchaseDTO) {
        //Obtener Provider, Store y Product por Id
        Provider provider = providerService.getProviderById(endPurchaseDTO.getProviderId());
        Store store = storeService.getStoreById(endPurchaseDTO.getStoreId());
        Product product = productService.getProductById(endPurchaseDTO.getProductId());


        ProviderMovement providerMovement = new ProviderMovement();
        // Mapear los datos desde la entidad
        providerMovement.setProviderMovementId(endPurchaseDTO.getProviderMovementId());
        providerMovement.setAmount(endPurchaseDTO.getAmount());
        providerMovement.setCreateAt(endPurchaseDTO.getCreateAt());
        providerMovement.setStatus(endPurchaseDTO.getStatus());

        // Guardar los datos de la compra en providerMovement
        providerMovementDao.save(providerMovement);
    }


}
