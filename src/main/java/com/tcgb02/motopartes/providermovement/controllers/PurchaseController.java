package com.tcgb02.motopartes.providermovement.controllers;

import com.tcgb02.motopartes.providermovement.models.dto.PurchaseDTO;
import com.tcgb02.motopartes.providermovement.models.services.IProductService;
import com.tcgb02.motopartes.providermovement.models.services.IPurchaseService;
import com.tcgb02.motopartes.providermovement.models.services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"}) //Para que pueda acceder al sevidor de Angular
@RestController //Porque es una API REST
@RequestMapping("/api/compras")
public class PurchaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IStoreService storeService;

    //Método para proporcionar datos de formulario a la interfaz de usuario
    @GetMapping("/formdata")
    public ResponseEntity<Map<String, Object>> getFormData() {
        Map<String, Object> formData = new HashMap<>();
        formData.put("products", productService.getAllProducts());
        formData.put("stores", storeService.getAllStores());
        return ResponseEntity.ok(formData);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createPurchase(@RequestBody PurchaseDTO purchaseDTO) {
        purchaseService.createPurchase(purchaseDTO);
        return ResponseEntity.ok("Compra generada exitosamente");

    }

   /* @PostMapping("/create")
      @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createPurchase(@RequestBody PurchaseDTO purchaseDTO) {
        try {
            purchaseService.createPurchase(purchaseDTO);
            return new ResponseEntity<>("Compra generada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}
