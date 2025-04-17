package com.yanadenv.backend.models.entitys;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
@Table(name = "apoderado")
public class Apoderado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApo;

    @Column(name = "nombre_apo", length = 50, nullable = false)
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
    
    @ManyToOne
    @JoinColumn(name = "id_par", referencedColumnName = "idPar", foreignKey = @ForeignKey(name = "fk_participante"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Participante participante;

    private static final long serialVersionUID = 1L;
    
    // Getters y Setters
	public Integer getIdApo() {
		return idApo;
	}

	public void setIdApo(Integer idApo) {
		this.idApo = idApo;
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

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
    
}
