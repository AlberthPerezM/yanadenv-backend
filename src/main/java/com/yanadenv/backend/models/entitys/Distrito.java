package com.yanadenv.backend.models.entitys;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "distrito")
public class Distrito {

    @Id
    @Column(name = "id_dist")
    private Integer idDist;

    @Column(name = "habilitado_dist", nullable = false)
    private boolean habilitadoDist;

    @Column(name = "nombre_dist")
    private String nombreDist;

    @ManyToOne
    @JoinColumn(name = "id_prov", nullable = false)
    @JsonBackReference   // <-- agregar aquí para romper el ciclo
    private Provincia provincia;


    /*@OneToMany(mappedBy = "distrito", cascade = CascadeType.ALL)
    private List<Centro> centros = new ArrayList<>();*/

	public Integer getIdDist() {
		return idDist;
	}

	public void setIdDist(Integer idDist) {
		this.idDist = idDist;
	}

	public boolean isHabilitadoDist() {
		return habilitadoDist;
	}

	public void setHabilitadoDist(boolean habilitadoDist) {
		this.habilitadoDist = habilitadoDist;
	}

	public String getNombreDist() {
		return nombreDist;
	}

	public void setNombreDist(String nombreDist) {
		this.nombreDist = nombreDist;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	/*public List<Centro> getCentros() {
		return centros;
	}

	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}*/

	
    
    
    
}
