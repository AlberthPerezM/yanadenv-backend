package com.yanadenv.backend.models.entitys;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "campania")
public class Campania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cam")
    private Integer idCam;

    @Column(name = "habilitado_cam", nullable = false)
    private boolean habilitadoCam;

    @Column(name = "nombre_cam", nullable = false, length = 255)
    private String nombreCam;

    @Column(name = "descripcion_cam", columnDefinition = "TEXT")
    private String descripcionCam;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference // <-- evita el bucle infinito

    @JoinColumn(name = "id_cent", nullable = false)
    private Centro centro;

    // Getters y Setters

    public Integer getIdCam() {
        return idCam;
    }

    public void setIdCam(Integer idCam) {
        this.idCam = idCam;
    }

    public boolean isHabilitadoCam() {
        return habilitadoCam;
    }

    public void setHabilitadoCam(boolean habilitadoCam) {
        this.habilitadoCam = habilitadoCam;
    }

    public String getNombreCam() {
        return nombreCam;
    }

    public void setNombreCam(String nombreCam) {
        this.nombreCam = nombreCam;
    }

    public String getDescripcionCam() {
        return descripcionCam;
    }

    public void setDescripcionCam(String descripcionCam) {
        this.descripcionCam = descripcionCam;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }
}
