/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.controller;

import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService; 
    
    //localhost:8080/provincias
    @RequestMapping("/provincias")
    public String provincias(Model model){
        List<Provincia> listadoProvincias = provinciaService.buscarProvinciasPorNombrePais("Argentina");
        model.addAttribute("listaprovincias",listadoProvincias);
        return "provincias";
    }
}
