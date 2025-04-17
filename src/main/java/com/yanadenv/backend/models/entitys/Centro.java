package com.yanadenv.backend.models.entitys;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "centro")
public class Centro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCen;

    @Column(name = "nombre_cen", length = 150, nullable = false)
    private String nombreCen;

    @Column(name = "latitud", precision = 10, scale = 6)
    private BigDecimal latitud;

    @Column(name = "longitud", precision = 10, scale = 6)
    private BigDecimal longitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_niv") // Clave foránea a Nivel
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Nivel nivel;

    // Getters y Setters
    public Integer getIdCen() {
        return idCen;
    }

    public void setIdCen(Integer idCen) {
        this.idCen = idCen;
    }

    public String getNombreCen() {
        return nombreCen;
    }

    public void setNombreCen(String nombreCen) {
        this.nombreCen = nombreCen;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    private static final long serialVersionUID = 1L;
}
