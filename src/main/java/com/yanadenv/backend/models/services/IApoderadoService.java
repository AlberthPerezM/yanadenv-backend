package com.yanadenv.backend.models.services;

import java.util.List;
import com.yanadenv.backend.models.entitys.Apoderado;
import com.yanadenv.backend.models.entitys.Participante;

public interface IApoderadoService {
	public List<Apoderado> findAll();
	public Apoderado findById(Integer id);
	public Apoderado save(Apoderado apoderado);
    public void delete(Integer id);
    //Listar Participantes
    public List<Participante> findAllParticipantes();
}
