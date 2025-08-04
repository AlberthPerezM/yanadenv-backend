package com.yanadenv.backend.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanadenv.backend.models.dao.IDatoClinicoDao;
import com.yanadenv.backend.models.entitys.DatoClinico;
import com.yanadenv.backend.models.services.IDatoClinicoService;

@Service
public class DatoClinicoServiceImpl implements IDatoClinicoService {

	@Autowired
	private IDatoClinicoDao datoClinicoDao;

	@Override
	@Transactional(readOnly = true)
	public List<DatoClinico> findAll() {
		return (List<DatoClinico>) datoClinicoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DatoClinico findById(Integer id) {
		return datoClinicoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DatoClinico save(DatoClinico datoClinico) {
		return datoClinicoDao.save(datoClinico);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		datoClinicoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countDatosClinicos() {
		return datoClinicoDao.count();
	}

	@Override
	public List<DatoClinico> findByParticipanteId(Integer idPar) {
		return datoClinicoDao.findByParticipanteIdPar(idPar);
	}
}