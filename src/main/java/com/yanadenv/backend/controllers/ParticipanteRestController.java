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
// Para permitir solicitudes desde Angular
@RestController
@CrossOrigin(origins = "http://localhost:4200")  
@RequestMapping("/api")
public class ParticipanteRestController {

    @Autowired
    private IParticipanteService participanteService;
    @Autowired
    private IExamenLaboratorioService examenLaboratorioService;

@PostMapping("/participantes/{idPar}/examenes")
public Participante asignarExamenes(@PathVariable Integer idPar, 
                                  @RequestBody List<ExamenLaboratorio> examenes) {
    // Logging para diagnóstico
    System.out.println("ID Participante: " + idPar);
    System.out.println("Exámenes recibidos: " + examenes);

    // Lógica de negocio
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