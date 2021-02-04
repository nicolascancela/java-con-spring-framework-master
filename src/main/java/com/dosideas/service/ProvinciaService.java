/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
public interface ProvinciaService {

    public Provincia buscarPorId(long id);

    public Collection<Provincia> buscarProvinciasPorNombreExacto(String nombre) throws NombreInvalidoException;

    public Collection<Provincia> buscarProvinciasPorNombreParcial(String nombreProvincia);

}
