package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.entitys.Participante;

public interface IParticipanteDao extends CrudRepository<Participante, Integer> {
    // Método para buscar participantes por examen de laboratorio
    List<Participante> findByExamenesLaboratorio_IdExa(Integer idExa);

    // Método corregido para buscar participantes por dato clínico
    List<Participante> findByDatoClinico_IdDat(Integer idDat);

    // Listar campañas
    @Query("from Campania")

    public List<Campania> findAllCampanias();

}
