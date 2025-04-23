package com.yanadenv.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yanadenv.backend.models.entitys.DatoClinico;
import com.yanadenv.backend.models.services.IDatoClinicoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DatoClinicoRestController {

    @Autowired
    private IDatoClinicoService datoClinicoService;

    // Obtener todos los datos clínicos
    @GetMapping("/datosclinicos")
    public List<DatoClinico> index() {
        return datoClinicoService.findAll();
    }

    // Obtener un dato clínico específico por ID
    @GetMapping("/datosclinicos/{id}")
    public DatoClinico show(@PathVariable Integer id) {
        return datoClinicoService.findById(id);
    }

    // Crear un nuevo dato clínico
    @PostMapping("/datosclinicos")
    @ResponseStatus(HttpStatus.CREATED)
    public DatoClinico create(@RequestBody DatoClinico datoClinico) {
        return datoClinicoService.save(datoClinico);
    }

    // Actualizar un dato clínico existente
    @PutMapping("/datosclinicos/{id}")
    public DatoClinico update(@RequestBody DatoClinico datoClinico, @PathVariable Integer id) {
        DatoClinico datoClinicoActual = datoClinicoService.findById(id);
        
        // Actualizar todos los campos necesarios
        datoClinicoActual.setFechaInicioSintomas(datoClinico.getFechaInicioSintomas());
        datoClinicoActual.setFechaTomaMuestra1(datoClinico.getFechaTomaMuestra1());
        datoClinicoActual.setFechaTomaMuestra2(datoClinico.getFechaTomaMuestra2());
        datoClinicoActual.setFiebre(datoClinico.getFiebre());
        datoClinicoActual.setTemperatura(datoClinico.getTemperatura());
        // Continúa con todos los demás campos que necesites actualizar...
        
        return datoClinicoService.save(datoClinicoActual);
    }

    // Eliminar un dato clínico por ID
    @DeleteMapping("/datosclinicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        datoClinicoService.delete(id);
    }

}