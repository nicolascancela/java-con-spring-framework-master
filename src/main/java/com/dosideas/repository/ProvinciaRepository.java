/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.repository;

import com.dosideas.domain.Provincia;

/**
 *
 * @author Usuario
 */
public interface ProvinciaRepository {
    Provincia findById(long id);
}
