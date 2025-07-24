package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.entitys.Provincia;

public interface IProvinciaService {
	public List<Provincia> findAll();
	public Provincia findById(Integer id);
	public Provincia save(Provincia provincia);
    public void delete(Integer id);
    public List<Distrito> findAllDistritos();
    
}
