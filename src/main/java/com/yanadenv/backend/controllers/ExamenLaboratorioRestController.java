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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ExamenLaboratorioRestController {

    @Autowired
    private IExamenLaboratorioService examenLaboratorioService;
    @Autowired
    private IParticipanteService participanteService;

    // Obtener todos los exámenes de laboratorio
    @GetMapping("/examenes")
    public List<ExamenLaboratorio> index() {
        return examenLaboratorioService.findAll();
    }

    // Obtener un examen de laboratorio específico por ID
    @GetMapping("/examenes/{id}")
    public ExamenLaboratorio show(@PathVariable Integer id) {
        return examenLaboratorioService.findById(id);
    }

    // Crear un nuevo examen de laboratorio
    @PostMapping("/examenes")
    @ResponseStatus(HttpStatus.CREATED)
    public ExamenLaboratorio create(@RequestBody ExamenLaboratorio examen) {
        return examenLaboratorioService.save(examen);
    }

    // Actualizar un examen de laboratorio existente
    @PutMapping("/examenes/{id}")
    public ExamenLaboratorio update(@RequestBody ExamenLaboratorio examen, @PathVariable Integer id) {
        ExamenLaboratorio examenActual = examenLaboratorioService.findById(id);
        examenActual.setNombreExa(examen.getNombreExa());
        examenActual.setExamenResultado(examen.getExamenResultado());
        examenActual.setFechaResultado(examen.getFechaResultado());
        return examenLaboratorioService.save(examenActual);
    }

    // Eliminar un examen de laboratorio por ID
    @DeleteMapping("/examenes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        examenLaboratorioService.delete(id);
    }

    // Controlador para examne_participante
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

    // También añadir endpoint para obtener todos los exámenes de un participante
    @GetMapping("/participantes/{idPar}/examenes")
    public List<ExamenLaboratorio> getExamenesByParticipante(@PathVariable Integer idPar) {
        Participante participante = participanteService.findById(idPar);
        return participante.getExamenesLaboratorio();
    }

    // Eliminar un examen de laboratorio de un participante
    @DeleteMapping("/participantes/{idPar}/examenes/{idExa}")
    public Participante removeExamenFromParticipante(@PathVariable Integer idPar, @PathVariable Integer idExa) {
        return participanteService.removeExamenFromParticipante(idPar, idExa);
    }

}
