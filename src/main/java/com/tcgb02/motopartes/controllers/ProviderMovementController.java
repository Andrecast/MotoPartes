package com.tcgb02.motopartes.controllers;

import com.tcgb02.motopartes.commons.models.dao.ILocationDao;
import com.tcgb02.motopartes.commons.models.dao.IProviderMovementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compra")
public class ProviderMovementController {

    @Autowired //Busca un bean que implemente el dao
    private IProviderMovementDao providerMovementDao;

    @GetMapping(value="/listar")
    public String listProviderMovements(Model model) { //usamos Model para pasar los datos a la vista
        model.addAttribute("titulo", "Listado de movimientos con proveedor");
        model.addAttribute("movimientos", providerMovementDao.findAll());
        return "listar";
    }

    //@GetMapping("/form/{storeId}") //Hacer la compra relacionada a una tienda, se obtiene el objeto store y se le pasa a la compra
    //public String create() {
        //return "compra/form";
    //}
}
