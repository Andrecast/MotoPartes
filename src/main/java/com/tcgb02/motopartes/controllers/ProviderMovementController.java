package com.tcgb02.motopartes.controllers;

import com.tcgb02.motopartes.commons.models.dao.ILocationDao;
import com.tcgb02.motopartes.commons.models.dao.IProviderMovementDao;
import com.tcgb02.motopartes.commons.models.dto.ProviderMovementDTO;
import com.tcgb02.motopartes.commons.models.entity.ProviderMovement;
import com.tcgb02.motopartes.commons.models.services.IProviderMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Porque es una API REST
@RequestMapping("/api") //Mapea el restcontroler y aquí generamos la URL
public class ProviderMovementController {

    @Autowired
    private IProviderMovementService providerMovementService;

    @GetMapping("/movimientos") //Para mapear la URL
    public List<ProviderMovementDTO> index(){ //Método index para listar los movimientos
        return providerMovementService.findAllAsDTO(); //Ir al service para obtener el listado de movimientos
    }
}
