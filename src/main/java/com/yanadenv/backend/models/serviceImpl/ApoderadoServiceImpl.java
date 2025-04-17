package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yanadenv.backend.models.dao.IApoderadoDao;
import com.yanadenv.backend.models.entitys.Apoderado;
import com.yanadenv.backend.models.entitys.Participante;
import com.yanadenv.backend.models.services.IApoderadoService;

@Service
public class ApoderadoServiceImpl implements IApoderadoService {
    
    @Autowired
    private IApoderadoDao apoderadoDao;
    
    // Obtener todos los apoderados
    @Override
    @Transactional(readOnly = true)
    public List<Apoderado> findAll() {
        return (List<Apoderado>) apoderadoDao.findAll();
    }
    
    // Buscar un apoderado por su ID
    @Override
    @Transactional(readOnly = true)
    public Apoderado findById(Integer id) {
        return apoderadoDao.findById(id).orElse(null);
    }
    
    // Guardar o actualizar un apoderado
    @Override
    @Transactional
    public Apoderado save(Apoderado apoderado) {
        return apoderadoDao.save(apoderado);
    }
    
    // Eliminar un apoderado por su ID
    @Override
    @Transactional
    public void delete(Integer id) {
        apoderadoDao.deleteById(id);
    }

	@Override
	public List<Participante> findAllParticipantes() {
		return apoderadoDao.findAllParticipantes();
		
	}
	
}
