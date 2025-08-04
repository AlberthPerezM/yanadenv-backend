package com.yanadenv.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    // Obtener todos los exámenes de un participante
    @GetMapping("/participantes/{idPar}/examenes")
    public List<ExamenLaboratorio> getExamenesByParticipante(@PathVariable Integer idPar) {
        Participante participante = participanteService.findById(idPar);
        return participante.getExamenesLaboratorio();
    }

    // Eliminar un examen de laboratorio asociado participante
    @DeleteMapping("/participantes/{idPar}/examenes/{idExa}")
    public Participante removeExamenFromParticipante(@PathVariable Integer idPar, @PathVariable Integer idExa) {
        return participanteService.removeExamenFromParticipante(idPar, idExa);
    }

    // Examenes de laboratorio asociados a un participante
    @PostMapping("/participantes/{idPar}/examenes")
    public Participante asignarExamenes(@PathVariable Integer idPar, @RequestBody List<ExamenLaboratorio> examenes) {
        Participante participante = participanteService.findById(idPar);
        if (participante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante no encontrado");
        }
        if (participante.getExamenesLaboratorio() == null) {
            participante.setExamenesLaboratorio(new ArrayList<>());
        }
        List<ExamenLaboratorio> examenesGuardados = new ArrayList<>();
        for (ExamenLaboratorio examen : examenes) {
            // Si el examen ya tiene ID, verificar que existe
            if (examen.getIdExa() != null) {
                ExamenLaboratorio examenExistente = examenLaboratorioService.findById(examen.getIdExa());
                if (examenExistente != null) {
                    examenesGuardados.add(examenExistente);
                }
            } else {
                // Si es nuevo examen, guardarlo primero
                ExamenLaboratorio examenGuardado = examenLaboratorioService.save(examen);
                examenesGuardados.add(examenGuardado);
            }
        }
        // Actualizar la relación bidireccional
        for (ExamenLaboratorio examen : examenesGuardados) {
            if (!participante.getExamenesLaboratorio().contains(examen)) {
                participante.getExamenesLaboratorio().add(examen);
                examen.getParticipantes().add(participante); // Mantener consistencia bidireccional
            }
        }
        // Logging del resultado antes de guardar
        System.out.println("Participante actualizado: " + participante);
        return participanteService.save(participante);
    }

}
