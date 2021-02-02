/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;

/**
 *
 * @author Usuario
 */
public class ProvinciaRepositoryImpl implements ProvinciaRepository {

    @Override
    public Provincia findById(long id) {
        Provincia p = new Provincia();
        p.setId(id);
        p.setNombre("PROVINCIA "+id);
        return p;
    }
    
}
