package com.yanadenv.backend.models.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yanadenv.backend.models.dao.IRegionDao;
import com.yanadenv.backend.models.entitys.Provincia;
import com.yanadenv.backend.models.entitys.Region;
import com.yanadenv.backend.models.services.IRegionService;


@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private IRegionDao regionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAll() {
        return (List<Region>) regionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Region findById(Integer id) {
        return regionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Region save(Region region) {
        return regionDao.save(region);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        regionDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Provincia> findAllProvincias() {
        return regionDao.findAllProvincias();
    }
}