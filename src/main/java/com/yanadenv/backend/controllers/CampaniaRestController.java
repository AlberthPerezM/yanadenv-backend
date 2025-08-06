package com.yanadenv.backend.controllers;

import java.util.List;

import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.services.ICampaniaService;
import com.yanadenv.backend.models.services.ICentroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CampaniaRestController {

    @Autowired
    private ICampaniaService campaniaService;

    @Autowired
    private ICentroService centroService;

    @GetMapping("/campanias")
    public List<Campania> findAll() {
        return campaniaService.findAll();
    }

    @GetMapping("/campanias/{id}")
    public ResponseEntity<Campania> findById(@PathVariable Integer id) {
        Campania campania = campaniaService.findById(id);
        return campania != null ? ResponseEntity.ok(campania) : ResponseEntity.notFound().build();
    }

    @PutMapping("/campanias/{id}")
    public ResponseEntity<Campania> update(@PathVariable Integer id, @RequestBody Campania campania) {
        Campania existente = campaniaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNombreCam(campania.getNombreCam());
        existente.setDescripcionCam(campania.getDescripcionCam());
        existente.setFechaInicio(campania.getFechaInicio());
        existente.setFechaFin(campania.getFechaFin());
        existente.setHabilitadoCam(campania.isHabilitadoCam());

        if (campania.getCentro() != null && campania.getCentro().getIdCent() != null) {
            Centro centro = centroService.findById(campania.getCentro().getIdCent());
            if (centro == null) {
                return ResponseEntity.badRequest().build();
            }
            existente.setCentro(centro);
        }

        return ResponseEntity.ok(campaniaService.save(existente));
    }

    @DeleteMapping("/campanias/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Campania campania = campaniaService.findById(id);
        if (campania == null)
            return ResponseEntity.notFound().build();

        campaniaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/centros/{id}/campanias")
    public ResponseEntity<List<Campania>> getByCentro(@PathVariable Integer id) {
        Centro centro = centroService.findById(id);
        if (centro == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(campaniaService.findByCentro(id));
    }

    @GetMapping("/campanias/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(campaniaService.countCampanias());
    }

    @PostMapping("/campanias")
    @ResponseStatus(HttpStatus.CREATED)
    public Campania create(@RequestBody Campania campania) {
        // Verifica si el centro existe
        Centro centro = centroService.findById(campania.getCentro().getIdCent());
        if (centro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Centro no encontrado");
        }

        // Asigna el centro existente a la campaña
        campania.setCentro(centro);

        return campaniaService.save(campania);
    }

}
