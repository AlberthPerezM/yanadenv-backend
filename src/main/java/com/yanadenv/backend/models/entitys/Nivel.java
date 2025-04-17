package com.yanadenv.backend.models.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNiv;

    @Column(name = "nombre_niv", length = 50, nullable = false)
    private String nombreNiv;

    // Getters y Setters
    public Integer getIdNiv() {
        return idNiv;
    }

    public void setIdNiv(Integer idNiv) {
        this.idNiv = idNiv;
    }

    public String getNombreNiv() {
        return nombreNiv;
    }

    public void setNombreNiv(String nombreNiv) {
        this.nombreNiv = nombreNiv;
    }

    private static final long serialVersionUID = 1L;
}