package com.yanadenv.backend.models.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yanadenv.backend.models.dao.IParticipanteDao;
import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;
import com.yanadenv.backend.models.services.IExamenLaboratorioService;
import com.yanadenv.backend.models.services.IParticipanteService;

@Service
public class ParticipanteServiceImpl implements IParticipanteService {
    @Autowired
    private IParticipanteDao participanteDao;

   
    
    @Override
    @Transactional(readOnly = true)
    public List<Participante> findAll() {
        return (List<Participante>) participanteDao.findAll();
    }
    
    // Buscar ID
    @Override
    @Transactional(readOnly = true)
    public Participante findById(Integer id) {
        return participanteDao.findById(id).orElse(null);
    }
    
    // Guardar
    @Override
    @Transactional 
    public Participante save(Participante participante) {
        return participanteDao.save(participante);
    }
    
    // Eliminar
    @Override
    @Transactional
    public void delete(Integer id) {
        participanteDao.deleteById(id);
    }

 // En ParticipanteServiceImpl, agregar:

    @Autowired
    private IExamenLaboratorioService examenService;

    @Override
    @Transactional(readOnly = true)
    public List<ExamenLaboratorio> findExamenesByParticipanteId(Integer idPar) {
        return examenService.findByParticipanteId(idPar);
    }

    @Override
    @Transactional
    public Participante addExamenToParticipante(Integer idPar, Integer idExa) {
        Participante participante = participanteDao.findById(idPar).orElse(null);
        ExamenLaboratorio examen = examenService.findById(idExa);
        
        if (participante != null && examen != null) {
            if (participante.getExamenesLaboratorio() == null) {
                participante.setExamenesLaboratorio(new ArrayList<>());
            }
            participante.getExamenesLaboratorio().add(examen);
            return participanteDao.save(participante);
        }
        return null;
    }



    @Override
    @Transactional(readOnly = true)
    public List<Participante> findByExamenId(Integer idExa) {
        return participanteDao.findByExamenesLaboratorio_IdExa(idExa);
    }


}
