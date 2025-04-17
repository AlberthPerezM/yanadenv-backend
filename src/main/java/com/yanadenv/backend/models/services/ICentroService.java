
package com.yanadenv.backend.models.services;

import java.util.List;

import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Nivel;

public interface ICentroService {
	public List<Centro> findAll();
	public Centro findById(Integer id);
	public Centro save(Centro centro);
    public void delete(Integer id);
    public List<Nivel> findAllNiveles();

}
