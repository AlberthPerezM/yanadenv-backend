package com.yanadenv.backend.models.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centro")
public class Centro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cent")
    private Integer idCent;

    @Column(name = "habilitado_cent", nullable = false)
    private boolean habilitadoCent;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @Column(name = "nivel", nullable = false)
    private Byte nivel;

    @Column(name = "nombre_cent", nullable = false, length = 255)
    private String nombreCent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dist", nullable = false)
    @JsonBackReference
    private Distrito distrito;

    @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonBackReference // <-- evita el bucle infinito

    private List<Campania> campanias = new ArrayList<>();

    // Getters y Setters

    public Integer getIdCent() {
        return idCent;
    }

    public void setIdCent(Integer idCent) {
        this.idCent = idCent;
    }

    public boolean isHabilitadoCent() {
        return habilitadoCent;
    }

    public void setHabilitadoCent(boolean habilitadoCent) {
        this.habilitadoCent = habilitadoCent;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Byte getNivel() {
        return nivel;
    }

    public void setNivel(Byte nivel) {
        this.nivel = nivel;
    }

    public String getNombreCent() {
        return nombreCent;
    }

    public void setNombreCent(String nombreCent) {
        this.nombreCent = nombreCent;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<Campania> getCampanias() {
        return campanias;
    }

    public void setCampanias(List<Campania> campanias) {
        this.campanias = campanias;
    }

}
