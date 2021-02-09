/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.fail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class) //@RunWith: Indica cual es la clase que usar para ejecutar el test --> Corre con el rund de Spring.
@SpringBootTest(classes = ApplicationConfig.class)
@Transactional
public class ProvinciaServiceImplTest {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
        Long id = 17L;
        System.out.println("========================================");
        System.out.println(provinciaService.getClass().getName()); //proxy --> clase que se interpone entre el invocante y el destino (transparente)
        Provincia provincia = provinciaService.buscarPorId(id);

        Assert.assertNotNull(provincia);
        Assert.assertEquals(id, provincia.getId());
        System.out.println("DATOS DE LA PROVINCIA:" + provincia.getNombre());
//COMPROBAMOS EMPIRICAMENTE QUE:
//1) Autowired devuelve la misma instancia!!
//2) que pasa sino tengo la dependencia? si spring no la encuentra. Excepción: UnsatisfiedDependencyException --> NoSuchBeanDefinitionException
        //No qualifying bean of type 'com.dosideas.service.ProvinciaService' 
//3) que pasa si tengo mucha clase que implementan una misma interface!
//Excepción -->  NoUniqueBeanDefinitionException: No qualifying bean of type 'com.dosideas.service.ProvinciaService' available: expected single matching bean but found 2: provinciaServiceImpl,provinciaServiceMock
    }

    @Test
    public void buscarPorNombreExacto_conNombreExistente_retornaColeccionNoVacia() throws NombreInvalidoException {
        String nombreProvincia = "Salta";
        Collection<Provincia> provincias = provinciaService.buscarProvinciasPorNombreExacto(nombreProvincia);
        Assert.assertTrue(provincias.size() > 0);
    }

    @Test
    public void buscarPorNombreExacto_conNombreNull_lanzaNombreInvalidoExcepcion() {
        NombreInvalidoException exceptionLanzada = assertThrows(NombreInvalidoException.class, () -> provinciaService.buscarProvinciasPorNombreExacto(null));
        String msj = exceptionLanzada.getMessage();
        Assert.assertEquals("El nombre es nulo", msj);
    }

    @Test
    public void buscarPorNombreExacto_conNombreMenorA3Caracteres_lanzaNombreInvalidoExcepcion() {
        NombreInvalidoException exceptionLanzada = assertThrows(NombreInvalidoException.class, () -> provinciaService.buscarProvinciasPorNombreExacto("ab"));
        String msj = exceptionLanzada.getMessage();
        Assert.assertEquals("El nombre ingresado es menor a 3 caracteres", msj);
    }
    
    @Test
    public void buscarPorNombreParcial_conNombreCoincidente_retornaProvincias(){
        String nombreProvincia = "SaN";
        Collection<Provincia> provincias = provinciaService.buscarProvinciasPorNombreParcial(nombreProvincia);
        System.out.println(provincias.size());
        //Assert.assertTrue(provincias.size()>0);
    }
    
    @Test
    public void guardarProvincia_conProvinciaNull_lanzaProvinciaInvalidaException(){
        Provincia provincia = null;
        Exception excepcion = assertThrows(ProvinciaInvalidaException.class, () -> provinciaService.guardarProvincia(provincia));
        Assert.assertEquals("La provincia es nula", excepcion.getMessage());
    }
    
    
    @Test
    public void guardarProvincia_conIDProvinciaNull_lanzaProvinciaInvalidaException(){
        Provincia provincia = new Provincia();
        provincia.setId(null);
        provincia.setNombre("PROVINCIA");
        provincia.setPais(null);
        Exception excepcion = assertThrows(ProvinciaInvalidaException.class, () -> provinciaService.guardarProvincia(provincia));
        Assert.assertEquals("El id de la provincia es nulo", excepcion.getMessage());
    }
    
    
    @Test
    public void guardarProvincia_conNombreProvinciaNull_lanzaProvinciaInvalidaException(){
        Provincia provincia = new Provincia();
        provincia.setId(1L);
        provincia.setNombre(null);
        provincia.setPais(null);
        Exception excepcion = assertThrows(ProvinciaInvalidaException.class, () -> provinciaService.guardarProvincia(provincia));
        Assert.assertEquals("El nombre de la provincia es nulo", excepcion.getMessage());
    }
    
    @Test
    public void buscarProvinciaPorPais_conNombrePaisExistente_devuelveProvincias(){
        String nombrePais = "Argentina";
        List<Provincia> provincias = provinciaService.buscarProvinciasPorNombrePais(nombrePais);
        Assert.assertTrue(provincias.size()>0);
    }
    
    //@Test
    //public void buscarPorNombrePais_conNombreValido_retornaProvincias();
    

    //findByNombreLike
}
