
package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.entitys.Centro;

public interface ICentroService {
    public List<Centro> findAll();

    public Centro findById(Integer id);

    public Centro save(Centro centro);

    public void delete(Integer id);

    public List<Campania> findAllCampanias();

    // Contador de centros
    Long countCentros();
}
