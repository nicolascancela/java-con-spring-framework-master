/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface ProvinciaRepository extends JpaRepository<Provincia,Long> {
    Provincia findById(long id);

}
