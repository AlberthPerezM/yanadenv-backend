package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Campania;

public interface ICampaniaService {
    public List<Campania> findAll();

    public Campania findById(Integer id);

    public Campania save(Campania campania);

    public void delete(Integer id);

    // Contador de campañas
    Long countCampanias();

    List<Campania> findByCentro(Integer idCentro);

}
