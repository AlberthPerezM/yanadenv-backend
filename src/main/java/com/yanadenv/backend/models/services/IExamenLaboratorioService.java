package com.yanadenv.backend.models.services;

import java.util.List;
import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;

public interface IExamenLaboratorioService {
    public List<ExamenLaboratorio> findAll();

    public ExamenLaboratorio findById(Integer id);

    public ExamenLaboratorio save(ExamenLaboratorio examenlaboratorio);

    public void delete(Integer id);

    public List<ExamenLaboratorio> findByParticipanteId(Integer idPar);

    public List<Participante> findParticipantesByExamenId(Integer idExa);
}
