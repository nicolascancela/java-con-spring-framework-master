/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
        Optional<Provincia> provinciaOpcional = provinciaRepository.findById(id);
        return provinciaOpcional.orElse(null);
    }

    private void validarInputNull(String nombre) throws NombreInvalidoException {
        if (nombre == null) {
            throw new NombreInvalidoException("El nombre es nulo");
        }
    }

    //IDEA ANTERIOR: Hacer el método los más generico posible para no tener tantos métodos.
    private void validarObjetoNull(Object objeto, String msjExcepcion) throws ProvinciaInvalidaException {
        if (objeto == null) {
            throw new ProvinciaInvalidaException(msjExcepcion);
        }
    }

    private void validarProvinciaNull(Provincia provincia) throws ProvinciaInvalidaException {
        if (provincia == null) {
            throw new ProvinciaInvalidaException("La provincia es nula");
        }
    }

    private void validarNombreProvinciaNull(String string) throws ProvinciaInvalidaException {
        if (string == null) {
            throw new ProvinciaInvalidaException("El nombre de la provincia es nulo");
        }
    }

    private void validarIDProvinciaNull(Long id) throws ProvinciaInvalidaException {
        if (id == null) {
            throw new ProvinciaInvalidaException("El id de la provincia es nulo");
        }
    }

    private void validarInputmenora3Caracteres(String nombre) throws NombreInvalidoException {
        if (nombre.length() < 3) {
            throw new NombreInvalidoException("El nombre ingresado es menor a 3 caracteres");
        }
    }

    @Override
    public Collection<Provincia> buscarProvinciasPorNombreExacto(String nombre) throws NombreInvalidoException {
        validarInputNull(nombre);
        validarInputmenora3Caracteres(nombre);
        return provinciaRepository.findByNombre(nombre);
    }

    @Override
    public Collection<Provincia> buscarProvinciasPorNombreParcial(String nombreProvincia) {
        return provinciaRepository.findByNombreContainingIgnoreCase(nombreProvincia);
    }

    @Override
    public void guardarProvincia(Provincia provincia) throws Exception {
        validarProvinciaNull(provincia);
        validarIDProvinciaNull(provincia.getId());
        validarNombreProvinciaNull(provincia.getNombre());
        validarInputmenora3Caracteres(provincia.getNombre());
        provinciaRepository.save(provincia);
    }

    @Override
    public List<Provincia> buscarProvinciasPorNombrePais(String nombrePais) {
        return provinciaRepository.findProvinciasPorPais(nombrePais);
    }
}

//Agregar: metodo de búsqueda que paso un nombre de una provincia y me devuelve la provincia que coinciden con ese nombre.
//Búsqueda: doy un string y me devuelve todas las provincias que contienen en su nombre ese String --> AN --> santa fe, santa cruz.
//Búsqueda: String con el nombre de un país y me devuelve todas las provincia que pertenezcan al pais.
