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

import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Nivel;
import com.yanadenv.backend.models.services.ICentroService;

@CrossOrigin(origins = "http://localhost:4200")  // Para Angular
@RestController
@RequestMapping("/api")  // Ruta base para todas las solicitudes de este controlador
public class CentroRestController {

    @Autowired
    private ICentroService centroService;

    // Obtener todos los centros
    @GetMapping("/centros")
    public List<Centro> index() {
        return centroService.findAll();
    }

    // Obtener un centro específico por ID
    @GetMapping("/centros/{id}")
    public Centro show(@PathVariable Integer id) {
        return centroService.findById(id);
    }

    // Crear un nuevo centro
    @PostMapping("/centros")
    @ResponseStatus(HttpStatus.CREATED)
    public Centro create(@RequestBody Centro centro) {
        return centroService.save(centro);
    }

    // Actualizar un centro existente
    @PutMapping("/centros/{id}")
    public Centro update(@RequestBody Centro centro, @PathVariable Integer id) {
        Centro centroActual = centroService.findById(id);
        centroActual.setNombreCen(centro.getNombreCen());
        centroActual.setLatitud(centro.getLatitud());
        centroActual.setLongitud(centro.getLongitud());
        centroActual.setNivel(centro.getNivel());
        return centroService.save(centroActual);
    }

    // Eliminar un centro por ID
    @DeleteMapping("/centros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        centroService.delete(id); 
    }
    //Niveles
    @GetMapping("/centros/niveles")
    public List<Nivel> listarNiveles() {
        return  centroService.findAllNiveles();
    }
}
