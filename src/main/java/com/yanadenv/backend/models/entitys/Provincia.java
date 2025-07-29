package com.yanadenv.backend.models.entitys;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @Column(name = "id_prov")
    private Integer idProv;

    @Column(name = "habilitado_prov", nullable = false)
    private boolean habilitadoProv;

    @Column(name = "nombre_prov")
    private String nombreProv;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "id_reg", nullable=false)
    @JsonBackReference
    private Region region;

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL)
    @JsonManagedReference  
    private List<Distrito> distritos = new ArrayList<>();

	public Integer getIdProv() {
		return idProv;
	}

	public void setIdProv(Integer idProv) {
		this.idProv = idProv;
	}

	public boolean isHabilitadoProv() {
		return habilitadoProv;
	}

	public void setHabilitadoProv(boolean habilitadoProv) {
		this.habilitadoProv = habilitadoProv;
	}

	public String getNombreProv() {
		return nombreProv;
	}

	public void setNombreProv(String nombreProv) {
		this.nombreProv = nombreProv;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}
    
  


    
    
}
