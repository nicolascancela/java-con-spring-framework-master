/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {
    
    @Autowired
    private ProvinciaRepository provinciaRepository;
    //Inversión de control: la clase invierte el control de su dependencia, no las controla, las recibe.
    //Brinda mecanismo para que un tercero setee las dependencias.

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