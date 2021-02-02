/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.DependencyServiceSolver1;
import com.dosideas.service.ProvinciaService;

/**
 *
 * @author Usuario
 */
public class ProvinciaServiceImpl implements ProvinciaService {
    
    private ProvinciaRepository provinciaRepository;
    
    //Inversión de control: la clase invierte el control de su dependencia, no las controla, las recibe.
    //Brinda mecanismo para que un tercero setee las dependencias.
    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository){
        this.provinciaRepository = provinciaRepository;
    }

    public ProvinciaRepository getProvinciaRepository() {
        return provinciaRepository;
    }

    public void setProvinciaRepository(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }
        
    @Override
    public Provincia buscarPorId(long id) {
        return provinciaRepository.findById(id);   
    }
}
