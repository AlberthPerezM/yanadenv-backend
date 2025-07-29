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
        DatoClinico datoActual = datoClinicoService.findById(id);
        datoActual.setFechaInicioSintomas(datoClinico.getFechaInicioSintomas()); // <-- LÍNEA CLAVE
        datoActual.setFechaTomaMuestra1(datoClinico.getFechaTomaMuestra1());
        datoActual.setFechaTomaMuestra2(datoClinico.getFechaTomaMuestra2());
        datoActual.setFiebre(datoClinico.getFiebre());
        datoActual.setTemperatura(datoClinico.getTemperatura());
        datoActual.setMialgias(datoClinico.getMialgias());
        datoActual.setCefalea(datoClinico.getCefalea());
        datoActual.setDolorOcular(datoClinico.getDolorOcular());
        datoActual.setDolorLumbar(datoClinico.getDolorLumbar());
        datoActual.setErupcionCutanea(datoClinico.getErupcionCutanea());
        datoActual.setConjuntivitis(datoClinico.getConjuntivitis());
        datoActual.setNauseasVomitos(datoClinico.getNauseasVomitos());
        datoActual.setOtrosSintomas1(datoClinico.getOtrosSintomas1());
        datoActual.setOtrosSintomas2(datoClinico.getOtrosSintomas2());
        datoActual.setOtrosSintomas3(datoClinico.getOtrosSintomas3());
        datoActual.setOtrosSintomas4(datoClinico.getOtrosSintomas4());
        datoActual.setDolorAbdominalIntenso(datoClinico.getDolorAbdominalIntenso());
        datoActual.setDolorToracicoDisnea(datoClinico.getDolorToracicoDisnea());
        datoActual.setDerrameSeroso(datoClinico.getDerrameSeroso());
        datoActual.setHipotermia(datoClinico.getHipotermia());
        datoActual.setDiuresisDisminuida(datoClinico.getDiuresisDisminuida());
        datoActual.setHepatomegalia(datoClinico.getHepatomegalia());
        datoActual.setIctericia(datoClinico.getIctericia());
        datoActual.setEstadoMentalAlterado(datoClinico.getEstadoMentalAlterado());
        datoActual.setHematocritoIncrementado(datoClinico.getHematocritoIncrementado());
        datoActual.setPulsoIndetectable(datoClinico.getPulsoIndetectable());
        datoActual.setExtremidadesFrias(datoClinico.getExtremidadesFrias());
        datoActual.setDifPresionArterial(datoClinico.getDifPresionArterial());
        datoActual.setCompromisoOrganos(datoClinico.getCompromisoOrganos());
        datoActual.setTipoCompromisoOrganos(datoClinico.getTipoCompromisoOrganos());
        datoActual.setSangradoGrave(datoClinico.getSangradoGrave());
        datoActual.setTipoSangrado(datoClinico.getTipoSangrado());
        datoActual.setGlasgowAperturaOcular(datoClinico.getGlasgowAperturaOcular());
        datoActual.setGlasgowAperturaMotora(datoClinico.getGlasgowAperturaMotora());
        datoActual.setGlasgowAperturaVerbal(datoClinico.getGlasgowAperturaVerbal());
        return datoClinicoService.save(datoActual);
    }

    // Eliminar un dato clínico por ID
    @DeleteMapping("/datosclinicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        datoClinicoService.delete(id);
    }
    // Contar todos los datos clínicos
    @GetMapping("/datosclinicos/count")
    public ResponseEntity<Long> countDatoClinicos() {
        Long count = datoClinicoService.countDatosClinicos();
        return ResponseEntity.ok(count);
    }

}
