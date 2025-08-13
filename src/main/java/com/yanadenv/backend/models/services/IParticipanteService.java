package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;

public interface IParticipanteService {
    public List<Participante> findAll();

    public Participante findById(Integer id);

    public Participante save(Participante participante);

    public void delete(Integer id);

    List<Participante> findByExamenId(Integer idExa);

    Long countParticipantes();

    /* Examen de laboratorio */

    List<ExamenLaboratorio> findExamenesByParticipanteId(Integer idPar);

    Participante addExamenToParticipante(Integer idPar, Integer idExa);

    Participante removeExamenFromParticipante(Integer idPar, Integer idExa);

    /* Campanias */
    public List<Campania> findAllCampanias();

}
