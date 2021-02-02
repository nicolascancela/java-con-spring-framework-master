/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.impl.ProvinciaServiceImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class DependencyServiceSolver1 {
    private Map<String, ProvinciaRepository> dependencias;
    private ProvinciaRepository actual;
    
    public DependencyServiceSolver1(){
        dependencias = new HashMap<String, ProvinciaRepository>();
        cargarDependencias();
    }
    
    private void cargarDependencias(){
        dependencias.put("repo", new ProvinciaRepositoryImpl());
        dependencias.put("mock", null);
    }
    
     public ProvinciaRepository getDependenciaRepo(String nombreDependencia){
        return dependencias.get(nombreDependencia);
    }
     
     /*public void agregarDependencia(String nombre, ProvinciaRepository provinciaRepository){
         dependencias.put(nombre, provinciaRepository);
     }*/

    public ProvinciaRepository getActual() {
        return actual;
    }

    public void setActual(String nombre) {
        this.actual = dependencias.get(nombre);
    }
     
     
}
