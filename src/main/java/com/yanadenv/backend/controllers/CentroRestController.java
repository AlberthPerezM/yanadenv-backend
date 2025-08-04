package com.yanadenv.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.services.ICentroService;
import com.yanadenv.backend.models.services.IDistritoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CentroRestController {

    @Autowired
    private ICentroService centroService;

    @Autowired
    private IDistritoService distritoService;

    // Obtener todos los centros
    @GetMapping("/centros")
    public List<Centro> index() {
        return centroService.findAll();
    }

    // Obtener un centro específico por ID
    @GetMapping("/centros/{id}")
    public ResponseEntity<Centro> show(@PathVariable Integer id) {
        Centro centro = centroService.findById(id);
        if (centro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(centro, HttpStatus.OK);
    }

    // Crear un nuevo centro
    @PostMapping("/centros")
    public ResponseEntity<Centro> create(@RequestBody Centro centro) {
        // Validar si distrito existe
        if (centro.getDistrito() == null || centro.getDistrito().getIdDist() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Distrito distrito = distritoService.findById(centro.getDistrito().getIdDist());
        if (distrito == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        centro.setDistrito(distrito);
        Centro nuevoCentro = centroService.save(centro);
        return new ResponseEntity<>(nuevoCentro, HttpStatus.CREATED);
    }

    // Actualizar un centro existente
    @PutMapping("/centros/{id}")
    public ResponseEntity<Centro> update(@RequestBody Centro centro, @PathVariable Integer id) {
        Centro centroActual = centroService.findById(id);
        if (centroActual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        centroActual.setNombreCent(centro.getNombreCent());
        centroActual.setDireccion(centro.getDireccion());
        centroActual.setHabilitadoCent(centro.isHabilitadoCent());
        centroActual.setLatitud(centro.getLatitud());
        centroActual.setLongitud(centro.getLongitud());
        centroActual.setNivel(centro.getNivel());

        if (centro.getDistrito() != null && centro.getDistrito().getIdDist() != null) {
            Distrito distrito = distritoService.findById(centro.getDistrito().getIdDist());
            if (distrito == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            centroActual.setDistrito(distrito);
        }
        Centro centroActualizado = centroService.save(centroActual);
        return new ResponseEntity<>(centroActualizado, HttpStatus.OK);
    }

    // Eliminar un centro por ID
    @DeleteMapping("/centros/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Centro centro = centroService.findById(id);
        if (centro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        centroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener los centros de un distrito
    @GetMapping("/distritos/{id}/centros")
    public ResponseEntity<List<Centro>> listarCentrosPorDistrito(@PathVariable Integer id) {
        Distrito distrito = distritoService.findById(id);
        if (distrito == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Centro> centros = distrito.getCentros();
        return new ResponseEntity<>(centros, HttpStatus.OK);
    }

    // Contar todos los centros
    @GetMapping("/centros/count")
    public ResponseEntity<Long> countCentros() {
        Long count = centroService.countCentros();
        return ResponseEntity.ok(count);
    }

}
