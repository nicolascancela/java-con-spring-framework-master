/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.ProvinciaService;

/**
 *
 * @author Usuario
 */
public class ProvinciaServiceImpl implements ProvinciaService {

    @Override
    public Provincia buscarPorId(long id) {
        ProvinciaRepository repo = new ProvinciaRepositoryImpl();
        return repo.findById(id);   
    }
    
}
