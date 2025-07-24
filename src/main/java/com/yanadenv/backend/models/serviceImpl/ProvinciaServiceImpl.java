package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import com.yanadenv.backend.models.dao.IProvinciaDao;
import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.entitys.Provincia;
import com.yanadenv.backend.models.services.IProvinciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {

    @Autowired
    private IProvinciaDao provinciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Provincia> findAll() {
        return (List<Provincia>) provinciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Provincia findById(Integer id) {
        return provinciaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Provincia save(Provincia provincia) {
        return provinciaDao.save(provincia);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        provinciaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Distrito> findAllDistritos() {
        return provinciaDao.findAllDistritos();
    }
}
