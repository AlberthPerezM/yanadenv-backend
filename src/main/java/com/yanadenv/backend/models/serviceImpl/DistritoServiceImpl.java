package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanadenv.backend.models.dao.IDistritoDao;
import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.services.IDistritoService;


@Service
public class DistritoServiceImpl implements IDistritoService {

    @Autowired 
    private IDistritoDao distritoDao;



    @Override
    @Transactional(readOnly = true) 
    public List<Distrito> findAll() {
        return (List<Distrito>) distritoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Distrito findById(Integer id) {
        return distritoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional 
    public Distrito save(Distrito distrito) {
        return distritoDao.save(distrito);
    }

    @Override
    @Transactional 
    public void delete(Integer id) {
        distritoDao.deleteById(id);
    }

	@Override
    @Transactional(readOnly = true)
	public List<Centro> findAllCentros() {
		 return distritoDao.findAllCentros();
	}
}