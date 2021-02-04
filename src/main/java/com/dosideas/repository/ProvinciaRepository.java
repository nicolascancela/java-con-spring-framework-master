/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usuario
 */
public interface ProvinciaRepository extends JpaRepository<Provincia,Long> {

    //Query Method: Darlo un metodo.
    public Collection<Provincia> findByNombre(String nombre);
    //Provincia findById(long id);

    public Collection<Provincia> findByNombreContainingIgnoreCase(String nombreProvincia);

    @Query("from Provincia p where p.pais.nombre=?1") //<--JPQL
    public List<Provincia> findProvinciasPorPais(String nombrePais);
}
