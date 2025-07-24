package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Provincia;
import com.yanadenv.backend.models.entitys.Region;

public interface IRegionService {
	public List<Region> findAll();
	public Region findById(Integer id);
	public Region save(Region region);
    public void delete(Integer id);
    public List<Provincia> findAllProvincias();
}
