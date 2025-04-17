package com.yanadenv.backend.models.entitys;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "participante")
public class Participante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idPar;

    @Column(name = "nombre_par", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;

    @Column(name = "tipo_documento", length = 25, nullable = false)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 12, nullable = false, unique = true)
    private String numeroDocumento;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "gestante", length = 2)
    private String gestante;

    @Column(name = "edad_gestacional")
    private Integer edadGestacional;
    
  
    @ManyToMany
    @JoinTable(
        name = "participante_examen_laboratorio",
        joinColumns = @JoinColumn(name = "id_par"),
        inverseJoinColumns = @JoinColumn(name = "id_exa")
    )
    private List<ExamenLaboratorio> examenesLaboratorio;
    
    private static final long serialVersionUID = 1L;

    // Getters y Setters
    public Integer getIdPar() {
        return idPar;
    }

    public void setIdPar(Integer idPar) {
        this.idPar = idPar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public Integer getEdadGestacional() {
        return edadGestacional;
    }

    public void setEdadGestacional(Integer edadGestacional) {
        this.edadGestacional = edadGestacional;
    }

	public List<ExamenLaboratorio> getExamenesLaboratorio() {
		return examenesLaboratorio;
	}

	public void setExamenesLaboratorio(List<ExamenLaboratorio> examenesLaboratorio) {
		this.examenesLaboratorio = examenesLaboratorio;
	}

}

