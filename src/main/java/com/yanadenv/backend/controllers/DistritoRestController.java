package com.yanadenv.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.services.IDistritoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DistritoRestController {

    @Autowired
    private IDistritoService distritoService;

    // Listar todos los distritos
    @GetMapping("/distritos")
    public List<Distrito> listar() {
        return distritoService.findAll();
    }

    // Obtener distrito por id
    @GetMapping("/distritos/{id}")
    public ResponseEntity<Distrito> obtenerPorId(@PathVariable Integer id) {
        Distrito distrito = distritoService.findById(id);
        if (distrito == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(distrito, HttpStatus.OK);
    }

    // Crear distrito
    @PostMapping("/distritos")
    @ResponseStatus(HttpStatus.CREATED)
    public Distrito crear(@RequestBody Distrito distrito) {
        return distritoService.save(distrito);
    }

    // Actualizar distrito
    @PutMapping("/distritos/{id}")
    public ResponseEntity<Distrito> actualizar(@RequestBody Distrito distrito, @PathVariable Integer id) {
        Distrito distritoActual = distritoService.findById(id);
        if (distritoActual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        distritoActual.setNombreDist(distrito.getNombreDist());
        distritoActual.setHabilitadoDist(distrito.isHabilitadoDist());
        distritoActual.setProvincia(distrito.getProvincia());

        Distrito distritoActualizado = distritoService.save(distritoActual);
        return new ResponseEntity<>(distritoActualizado, HttpStatus.OK);
    }

    // Eliminar distrito por id
    @DeleteMapping("/distritos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Distrito distrito = distritoService.findById(id);
        if (distrito == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        distritoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Agregar un dato clinico
}
