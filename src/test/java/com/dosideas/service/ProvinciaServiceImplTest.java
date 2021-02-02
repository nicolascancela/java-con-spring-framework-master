/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.service.impl.ProvinciaServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class ProvinciaServiceImplTest {
    
    @Test
    public void buscarPorId_conIdExistente_retornaProvincia(){
        ProvinciaService service = new ProvinciaServiceImpl();
        Long id = 22L;
        Provincia provincia = service.buscarPorId(id);
        Assert.assertNotNull(provincia);
        Assert.assertEquals(id, provincia.getId());
        
    }
    
}
