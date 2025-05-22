package com.yanadenv.backend.models.services;


import java.util.List;

import com.yanadenv.backend.models.entitys.DatoClinico;
import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;

public interface IParticipanteService {
    public List<Participante> findAll();
    public Participante findById(Integer id);
    public Participante save(Participante participante);
    public void delete(Integer id);
    List<Participante> findByExamenId(Integer idExa);
    // En IParticipanteService, agregar:
    List<ExamenLaboratorio> findExamenesByParticipanteId(Integer idPar);
    Participante addExamenToParticipante(Integer idPar, Integer idExa);
    //Service
    List<DatoClinico> findDatosClinicosByParticipanteId(Integer idPar);
    Participante addDatoClinicoToParticipante(Integer idPar, Integer idDat);
    Participante removeDatoClinicoFromParticipante(Integer idPar, Integer idDat);
    /*Contador */
    Long countParticipantes();


}
