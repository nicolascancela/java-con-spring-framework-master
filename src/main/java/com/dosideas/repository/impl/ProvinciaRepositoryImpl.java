
package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;

public class ProvinciaRepositoryImpl  {

    public Provincia findById(long id) {
        Provincia p = new Provincia();
        p.setId(id);
        p.setNombre("NO SON UN FRIJOL, PROVINCIA --> "+id);
        return p;
    }
    
}
