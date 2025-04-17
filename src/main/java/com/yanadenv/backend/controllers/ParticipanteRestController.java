package com.yanadenv.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;
import com.yanadenv.backend.models.services.IExamenLaboratorioService;
import com.yanadenv.backend.models.services.IParticipanteService;

@CrossOrigin(origins = "http://localhost:4200")  // Para permitir solicitudes desde Angular
@RestController
@RequestMapping("/api")
public class ParticipanteRestController {

    @Autowired
    private IParticipanteService participanteService;
    @Autowired
    private IExamenLaboratorioService examenLaboratorioService;

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
    
    //Controlador para examne_participante
    @PostMapping("/participantes/{idPar}/examenes/{idExa}")
    public Participante asignarExamen(@PathVariable Integer idPar, @PathVariable Integer idExa) {
        Participante participante = participanteService.findById(idPar);
        ExamenLaboratorio examen = examenLaboratorioService.findById(idExa);
        
        if (participante.getExamenesLaboratorio() == null) {
            participante.setExamenesLaboratorio(new ArrayList<>());
        }
        participante.getExamenesLaboratorio().add(examen);
        
        return participanteService.save(participante);
    }

    @DeleteMapping("/participantes/{idPar}/examenes/{idExa}")
    public Participante eliminarExamen(@PathVariable Integer idPar, @PathVariable Integer idExa) {
        Participante participante = participanteService.findById(idPar);
        ExamenLaboratorio examen = examenLaboratorioService.findById(idExa);
        
        participante.getExamenesLaboratorio().remove(examen);
        
        return participanteService.save(participante);
    }

    // También añadir endpoint para obtener todos los exámenes de un participante
    @GetMapping("/participantes/{idPar}/examenes")
    public List<ExamenLaboratorio> getExamenesByParticipante(@PathVariable Integer idPar) {
        Participante participante = participanteService.findById(idPar);
        return participante.getExamenesLaboratorio();
    }
    

}