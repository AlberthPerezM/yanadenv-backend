package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanadenv.backend.models.dao.ICentroDao;
import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Nivel;
import com.yanadenv.backend.models.services.ICentroService;

@Service
public class CentroServiceImpl implements ICentroService{
	@Autowired
    private ICentroDao centroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Centro> findAll() {
		return (List<Centro>) centroDao.findAll();
	}
	
    //Buscar ID
	@Override
	@Transactional(readOnly = true)
	public Centro findById(Integer id) {
		return centroDao.findById(id).orElse(null);
	}
	
    //Guardar
	@Override
	@Transactional 
	public Centro save(Centro centro) {
		return centroDao.save(centro);
	}
    //Eliminar
	@Override
	@Transactional
	public void delete(Integer id) {
		centroDao.deleteById(id);
	}
    //Lista de niveles
	@Override
	@Transactional(readOnly = true)
	public List<Nivel> findAllNiveles() {
	    return centroDao.findAllNiveles();
	}
}
