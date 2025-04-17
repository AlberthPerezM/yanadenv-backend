package com.yanadenv.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yanadenv.backend.models.entitys.Apoderado;
import com.yanadenv.backend.models.entitys.Participante;
import com.yanadenv.backend.models.services.IApoderadoService;

@CrossOrigin(origins = "http://localhost:4200")  // Para Angular
@RestController
@RequestMapping("/api")  // Ruta base para todas las solicitudes de este controlador
public class ApoderadoRestController {

    @Autowired
    private IApoderadoService apoderadoService;

    // Obtener todos los apoderados
    @GetMapping("/apoderados")
    public List<Apoderado> index() {
        return apoderadoService.findAll();
    }

    // Obtener un apoderado específico por ID
    @GetMapping("/apoderados/{id}")
    public Apoderado show(@PathVariable Integer id) {
        return apoderadoService.findById(id);
    }

    // Crear un nuevo apoderado
    @PostMapping("/apoderados")
    @ResponseStatus(HttpStatus.CREATED)
    public Apoderado create(@RequestBody Apoderado apoderado) {
        return apoderadoService.save(apoderado);
    }

    //Actualizar un apoderado existente
    @PutMapping("/apoderados/{id}")
    public Apoderado update(@RequestBody Apoderado apoderado, @PathVariable Integer id) {
        Apoderado apoderadoActual = apoderadoService.findById(id);
            apoderadoActual.setNombre(apoderado.getNombre());
            apoderadoActual.setApellidoPaterno(apoderado.getApellidoPaterno());
            apoderadoActual.setApellidoMaterno(apoderado.getApellidoMaterno());
            apoderadoActual.setSexo(apoderado.getSexo());
            apoderadoActual.setTipoDocumento(apoderado.getTipoDocumento());
            apoderadoActual.setNumeroDocumento(apoderado.getNumeroDocumento());
            apoderadoActual.setEdad(apoderado.getEdad());
            apoderadoActual.setParticipante(apoderado.getParticipante());
            return apoderadoService.save(apoderadoActual);
    }


    // Eliminar un apoderado por ID
    @DeleteMapping("/apoderados/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        apoderadoService.delete(id);
    }
    // Listar participantes
    @GetMapping("/apoderados/participantes")
    public List<Participante> listarParticipantes() {	
        return  apoderadoService.findAllParticipantes();
    } 
}
