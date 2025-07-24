package com.yanadenv.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.entitys.Provincia;
import com.yanadenv.backend.models.services.IProvinciaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProvinciaRestController {

    @Autowired
    private IProvinciaService provinciaService;

    // Obtener todas las provincias
    @GetMapping("/provincias")
    public List<Provincia> index() {
        return provinciaService.findAll();
    }

    // Obtener una provincia por ID
    @GetMapping("/provincias/{id}")
    public ResponseEntity<Provincia> show(@PathVariable Integer id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(provincia, HttpStatus.OK);
    }

    // Crear una provincia
    @PostMapping("/provincias")
    @ResponseStatus(HttpStatus.CREATED)
    public Provincia create(@RequestBody Provincia provincia) {
        return provinciaService.save(provincia);
    }

    // Actualizar una provincia existente
    @PutMapping("/provincias/{id}")
    public ResponseEntity<Provincia> update(@RequestBody Provincia provincia, @PathVariable Integer id) {
        Provincia provinciaActual = provinciaService.findById(id);
        if (provinciaActual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinciaActual.setNombreProv(provincia.getNombreProv());
        provinciaActual.setHabilitadoProv(provincia.isHabilitadoProv());
        provinciaActual.setRegion(provincia.getRegion());
        // No cambiar fechaCreacion en update
        Provincia provinciaActualizada = provinciaService.save(provinciaActual);
        return new ResponseEntity<>(provinciaActualizada, HttpStatus.OK);
    }

    // Eliminar una provincia
    @DeleteMapping("/provincias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener los distritos de una provincia
    @GetMapping("/provincias/{id}/distritos")
    public ResponseEntity<List<Distrito>> listarDistritosPorProvincia(@PathVariable Integer id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Distrito> distritos = provincia.getDistritos();
        return new ResponseEntity<>(distritos, HttpStatus.OK);
    }
}
