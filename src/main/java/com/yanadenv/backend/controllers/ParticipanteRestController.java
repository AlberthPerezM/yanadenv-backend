package com.yanadenv.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.entitys.Participante;
import com.yanadenv.backend.models.services.ICampaniaService;
import com.yanadenv.backend.models.services.IDatoClinicoService;
import com.yanadenv.backend.models.services.IParticipanteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ParticipanteRestController {

	@Autowired
	private IParticipanteService participanteService;
	@Autowired
	private ICampaniaService campaniaService;

	// Obtener todos los participantes
	@GetMapping("/participantes")
	public List<Participante> index() {
		return participanteService.findAll();
	}

	// Obtener un participante específico por ID
	@GetMapping("/participantes/{id}")
	public Participante show(@PathVariable Integer id) {
		return participanteService.findById(id);
	}

	// Crear un nuevo participante
	@PostMapping("/participantes")
	@ResponseStatus(HttpStatus.CREATED)
	public Participante create(@RequestBody Participante participante) {
		return participanteService.save(participante);
	}

	// Actualizar un participante existente
	@PutMapping("/participantes/{id}")
	public Participante update(@RequestBody Participante participante, @PathVariable Integer id) {
		Participante participanteActual = participanteService.findById(id);
		participanteActual.setNombre(participante.getNombre());
		participanteActual.setApellidoPaterno(participante.getApellidoPaterno());
		participanteActual.setApellidoMaterno(participante.getApellidoMaterno());
		participanteActual.setSexo(participante.getSexo());
		participanteActual.setTipoDocumento(participante.getTipoDocumento());
		participanteActual.setNumeroDocumento(participante.getNumeroDocumento());
		participanteActual.setEdad(participante.getEdad());
		participanteActual.setGestante(participante.getGestante());
		participanteActual.setEdadGestacional(participante.getEdadGestacional());
		return participanteService.save(participanteActual);
	}

	// Eliminar un participante por ID
	@DeleteMapping("/participantes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		participanteService.delete(id);
	}

	// Contador de participantes
	@GetMapping("/participantes/count")
	public Long countParticipantes() {
		return participanteService.countParticipantes();
	}

	@GetMapping("/participantes/campanias")
	public List<Campania> findAllCampanias() {
		return participanteService.findAllCampanias();
	}

}