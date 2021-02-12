/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.controller.rest;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.ProvinciaInvalidaException;
import com.dosideas.service.ProvinciaService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/provincia")
//localhost:8080/api/provincia
public class ProvinciaRestController {
    
    @Autowired
    private ProvinciaService provinciaService;
    
    @GetMapping("/{id}")
    //localhost:8080/api/provincia/3
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaInvalidaException {
        Provincia provincia = provinciaService.buscarPorId(id);
        if (provincia == null) {
            throw new ProvinciaInvalidaException("Provincia no encontrada");
        }
        return provincia;
    }
    
    @GetMapping("/byPais/{nombrePais}")
    //localhost:8080/api/provincia/byPais/Argentina
    public List<Provincia>buscarPorPais(@PathVariable String nombrePais){
        return provinciaService.buscarProvinciasPorNombrePais(nombrePais);
    }
    
    @GetMapping("/contains/{nombreProvincia}")
    //localhost:8080/api/provincia/contains/San
    public Collection<Provincia>buscarPorNombreParcial(@PathVariable String nombreProvincia){
        return provinciaService.buscarProvinciasPorNombreParcial(nombreProvincia);
    }
    
    
    
    
    
    
}
