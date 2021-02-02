/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.impl.ProvinciaServiceImpl;

/**
 *
 * @author Usuario
 */
public class ResolvedorDependencias {
    
    //Problema: La construcicón implica consturir dependencias y demás --> construir un objeto es un kilombo!!
    //Solución: Object Factory: objeto que constrye objectos en nombre de alguien.
    public ProvinciaService getProvinciaService(){
        ProvinciaRepository repo = new ProvinciaRepositoryImpl();
        return new ProvinciaServiceImpl(repo);
    }
    
    public Object get(String nombreClase){  
        return new Object();
    }
    
    /*public <T> get(Class<T> clazz){
        return
    }*/
    
    
    
    
    
    
}
