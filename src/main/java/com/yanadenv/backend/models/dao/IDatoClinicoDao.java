package com.yanadenv.backend.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.DatoClinico;

public interface IDatoClinicoDao extends CrudRepository<DatoClinico,Integer> {


}
