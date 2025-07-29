// Region.java
package com.yanadenv.backend.models.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "id_reg")
    private Integer idReg;

    @Column(name = "habilitado_reg", nullable = false)
    private boolean habilitadoReg;

    @Column(name = "nombre_reg")
    private String nombreReg;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Provincia> provincias= new ArrayList<>();


    // Getters y setters

    public Integer getIdReg() {
        return idReg;
    }

    public void setIdReg(Integer idReg) {
        this.idReg = idReg;
    }

    public boolean isHabilitadoReg() {
        return habilitadoReg;
    }

    public void setHabilitadoReg(boolean habilitadoReg) {
        this.habilitadoReg = habilitadoReg;
    }

    public String getNombreReg() {
        return nombreReg;
    }

    public void setNombreReg(String nombreReg) {
        this.nombreReg = nombreReg;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
}
