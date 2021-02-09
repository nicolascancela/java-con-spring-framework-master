/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ProvinciaService {

    public Provincia buscarPorId(long id);

    public Collection<Provincia> buscarProvinciasPorNombreExacto(String nombre) throws NombreInvalidoException;

    public Collection<Provincia> buscarProvinciasPorNombreParcial(String nombreProvincia);
    
    public void guardarProvincia(Provincia provincia) throws Exception;

    public List<Provincia> buscarProvinciasPorNombrePais(String nombrePais);
}
