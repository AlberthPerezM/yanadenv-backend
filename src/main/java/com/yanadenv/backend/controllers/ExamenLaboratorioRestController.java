package com.yanadenv.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.services.IExamenLaboratorioService;

@CrossOrigin(origins = "http://localhost:4200")  // Permitir solicitudes desde Angular
@RestController
@RequestMapping("/api")
public class ExamenLaboratorioRestController {

    @Autowired
    private IExamenLaboratorioService examenLaboratorioService;

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
    
  
}
