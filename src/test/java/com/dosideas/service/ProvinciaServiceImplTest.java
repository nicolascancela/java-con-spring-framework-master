/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class) //@RunWith: Indica cual es la clase que usar para ejecutar el test --> Corre con el rund de Spring.
@SpringBootTest(classes = ApplicationConfig.class)
@Transactional
public class ProvinciaServiceImplTest {
    
    @Autowired
    private ProvinciaService provinciaService;
    
    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
        Long id = 17L;
        Provincia provincia = provinciaService.buscarPorId(id);
        Assert.assertNotNull(provincia);
        Assert.assertEquals(id, provincia.getId());
        System.out.println("DATOS DE LA PROVINCIA:"+ provincia.getNombre());

        

//COMPROBAMOS EMPIRICAMENTE QUE:
//1) Autowired devuelve la misma instancia!!
//2) que pasa sino tengo la dependencia? si spring no la encuentra. Excepción: UnsatisfiedDependencyException --> NoSuchBeanDefinitionException
 //No qualifying bean of type 'com.dosideas.service.ProvinciaService' 
//3) que pasa si tengo mucha clase que implementan una misma interface!
//Excepción -->  NoUniqueBeanDefinitionException: No qualifying bean of type 'com.dosideas.service.ProvinciaService' available: expected single matching bean but found 2: provinciaServiceImpl,provinciaServiceMock
    }

    
    
    
}
