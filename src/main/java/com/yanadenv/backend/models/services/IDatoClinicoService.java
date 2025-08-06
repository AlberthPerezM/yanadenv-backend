package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.DatoClinico;

public interface IDatoClinicoService {

    public List<DatoClinico> findAll();

    public DatoClinico findById(Integer id);

    public DatoClinico save(DatoClinico datoClinico);

    public void delete(Integer id);

    /* Contador */
    Long countDatosClinicos();

    public DatoClinico findByParticipanteId(Integer idPar);
}