package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Distrito;

public interface IDistritoService {
	public List<Distrito> findAll();
	public Distrito findById(Integer id);
	public Distrito save(Distrito distrito);
    public void delete(Integer id);
    //public List<Distrito> findAllDistritos();
}
