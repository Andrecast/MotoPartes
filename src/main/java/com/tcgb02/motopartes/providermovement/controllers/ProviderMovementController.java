package com.tcgb02.motopartes.providermovement.controllers;

import com.tcgb02.motopartes.providermovement.models.dto.ProviderMovementDTO;
import com.tcgb02.motopartes.providermovement.models.services.IProviderMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}) //Para que pueda acceder al sevidor de Angular
@RestController //Porque es una API REST
@RequestMapping("/api") //Mapea el restcontroler y aquí generamos la URL
public class ProviderMovementController {

    @Autowired
    private IProviderMovementService providerMovementService;

    @GetMapping("/movimientos") //Para mapear la URL
    public List<ProviderMovementDTO> index(){ //Método index para listar los movimientos
        return providerMovementService.findAllAsDTO(); //Ir al service para obtener el listado de movimientos
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<ProviderMovementDTO> findById(@PathVariable Long id) {
        ProviderMovementDTO movementDTO = providerMovementService.findById(id);

        if (movementDTO != null) {
            return new ResponseEntity<>(movementDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
