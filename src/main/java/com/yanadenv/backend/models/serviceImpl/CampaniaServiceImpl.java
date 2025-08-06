package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanadenv.backend.models.dao.ICampaniaDao;
import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.services.ICampaniaService;

@Service
public class CampaniaServiceImpl implements ICampaniaService {

    @Autowired
    private ICampaniaDao campaniaDao;

    @Override
    public List<Campania> findAll() {
        return (List<Campania>) campaniaDao.findAll();
    }

    @Override
    public Campania findById(Integer id) {
        return campaniaDao.findById(id).orElse(null);
    }

    @Override
    public Campania save(Campania campania) {
        return campaniaDao.save(campania);
    }

    @Override
    public void delete(Integer id) {
        campaniaDao.deleteById(id);
    }

    @Override
    public List<Campania> findByCentro(Integer idCentro) {
        return campaniaDao.findByCentro_IdCent(idCentro);
    }

    @Override
    public Long countCampanias() {
        return campaniaDao.count();
    }
}
