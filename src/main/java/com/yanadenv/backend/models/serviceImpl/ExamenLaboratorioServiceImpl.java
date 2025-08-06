package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanadenv.backend.models.dao.IExamenLaboratorioDao;
import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;
import com.yanadenv.backend.models.services.IExamenLaboratorioService;

@Service
public class ExamenLaboratorioServiceImpl implements IExamenLaboratorioService {

    @Autowired
    private IExamenLaboratorioDao examenLaboratorioDao;

    @Override
    @Transactional(readOnly = true)
    public List<ExamenLaboratorio> findAll() {
        return (List<ExamenLaboratorio>) examenLaboratorioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ExamenLaboratorio findById(Integer id) {
        return examenLaboratorioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ExamenLaboratorio save(ExamenLaboratorio examen) {
        return examenLaboratorioDao.save(examen);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        examenLaboratorioDao.deleteById(id);
    }

    // Retorna todos los exámenes de laboratorio en los que ha participado el

    @Override
    @Transactional(readOnly = true)
    public List<ExamenLaboratorio> findByParticipanteId(Integer idPar) {
        return examenLaboratorioDao.findByParticipantes_IdPar(idPar);

    }

    // Retorna todos los participantes que están asociados al examen de laboratorio

    @Override
    public List<Participante> findParticipantesByExamenId(Integer idExa) {
        return examenLaboratorioDao.findParticipantesByExamenId(idExa);
    }

}
