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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yanadenv.backend.models.entitys.Provincia;
import com.yanadenv.backend.models.entitys.Region;
import com.yanadenv.backend.models.services.IRegionService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api") 
public class RegionRestController {

    @Autowired
    private IRegionService regionService;

    // Obtener todas las regiones
    @GetMapping("/regiones")
    public List<Region> index() {
        return regionService.findAll();
    }

    // Obtener una región específica por ID
    @GetMapping("/regiones/{id}")
    public Region show(@PathVariable Integer id) {
        return regionService.findById(id);
    }

    // Crear una nueva región
    @PostMapping("/regiones")
    @ResponseStatus(HttpStatus.CREATED)
    public Region create(@RequestBody Region region) {
        return regionService.save(region);
    }

    // Actualizar una región existente
    @PutMapping("/regiones/{id}")
    public Region update(@RequestBody Region region, @PathVariable Integer id) {
        Region regionActual = regionService.findById(id);
        regionActual.setHabilitadoReg(region.isHabilitadoReg());
        regionActual.setNombreReg(region.getNombreReg());
        regionActual.setProvincias(region.getProvincias());
        return regionService.save(regionActual);
    }

    // Eliminar una región por ID
    @DeleteMapping("/regiones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        regionService.delete(id);
    }
    

    // Obtener provincias de una región
    @GetMapping("/regiones/{id}/provincias")
    public ResponseEntity<List<Provincia>> listarProvinciasPorRegion(@PathVariable Integer id) {
        Region region = regionService.findById(id);
        if (region == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Provincia> provincias = region.getProvincias();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }
}