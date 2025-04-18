package com.yanadenv.backend.models.entitys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "examen_laboratorio")
public class ExamenLaboratorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exa")
    private Integer idExa;

    @Column(name = "nombre_exa", length = 100, nullable = false)
    private String nombreExa;

    @Column(name = "examen_resultado", length = 100)
    private String examenResultado;

   


@Column(name = "fecha_resultado")
private LocalDate fechaResultado;

    
    @ManyToMany(mappedBy = "examenesLaboratorio", fetch = FetchType.LAZY  ,cascade = {CascadeType.PERSIST, CascadeType.MERGE} // Añadir cascada
)
    @JsonIgnore
    private List<Participante> participantes = new ArrayList<>();

    // Getters y Setters
    public Integer getIdExa() {
        return idExa;
    }

    public void setIdExa(Integer idExa) {
        this.idExa = idExa;
    }

    public String getNombreExa() {
        return nombreExa;
    }

    public void setNombreExa(String nombreExa) {
        this.nombreExa = nombreExa;
    }

    public String getExamenResultado() {
        return examenResultado;
    }

    public void setExamenResultado(String examenResultado) {
        this.examenResultado = examenResultado;
    }

    public LocalDate getFechaResultado() {
        return fechaResultado;
    }
    
    public void setFechaResultado(LocalDate fechaResultado) {
        this.fechaResultado = fechaResultado;
    }
    

    public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	private static final long serialVersionUID = 1L;
}
