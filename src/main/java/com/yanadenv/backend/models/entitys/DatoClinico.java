package com.yanadenv.backend.models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "dato_clinico")
public class DatoClinico implements Serializable{

 
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dat")
    private Integer idDat;

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    // Datos generales
    @Column(name = "fecha_inicio_sintomas")
    private LocalDate fechaInicioSintomas;

    @Column(name = "fecha_toma_muestra_1")
    private LocalDate fechaTomaMuestra1;

    @Column(name = "fecha_toma_muestra_2")
    private LocalDate fechaTomaMuestra2;

    // Síntomas frecuentes
    @Column(name = "fiebre")
    private Boolean fiebre;

    @Column(name = "temperatura")
    private Float temperatura;

    @Column(name = "mialgias")
    private Boolean mialgias;

    @Column(name = "cefalea")
    private Boolean cefalea;

    @Column(name = "dolor_ocular")
    private Boolean dolorOcular;

    @Column(name = "dolor_lumbar")
    private Boolean dolorLumbar;

    @Column(name = "erupcion_cutanea")
    private Boolean erupcionCutanea;

    @Column(name = "conjuntivitis")
    private Boolean conjuntivitis;

    @Column(name = "nauseas_vomitos")
    private Boolean nauseasVomitos;

    @Column(name = "otros_sintomas_1")
    private String otrosSintomas1;

    @Column(name = "otros_sintomas_2")
    private String otrosSintomas2;

    @Column(name = "otros_sintomas_3")
    private String otrosSintomas3;

    @Column(name = "otros_sintomas_4")
    private String otrosSintomas4;

    // Signos de alarma
    @Column(name = "dolor_abdominal_intenso")
    private Boolean dolorAbdominalIntenso;

    @Column(name = "dolor_toracico_disnea")
    private Boolean dolorToracicoDisnea;

    @Column(name = "derrame_seroso")
    private Boolean derrameSeroso;

    @Column(name = "hipotermia")
    private Boolean hipotermia;

    @Column(name = "diuresis_disminuida")
    private Boolean diuresisDisminuida;

    @Column(name = "hepatomegalia")
    private Boolean hepatomegalia;

    @Column(name = "ictericia")
    private Boolean ictericia;

    @Column(name = "estado_mental_alterado")
    private Boolean estadoMentalAlterado;

    @Column(name = "hematocrito_incrementado")
    private Boolean hematocritoIncrementado;

    // Signos de gravedad
    @Column(name = "pulso_indetectable")
    private Boolean pulsoIndetectable;

    @Column(name = "extremidades_frias")
    private Boolean extremidadesFrias;

    @Column(name = "dif_presion_arterial")
    private Boolean difPresionArterial;

    @Column(name = "compromiso_organos")
    private Boolean compromisoOrganos;

    @Column(name = "tipo_compromiso_organos")
    private String tipoCompromisoOrganos;

    @Column(name = "sangrado_grave")
    private Boolean sangradoGrave;

    @Column(name = "tipo_sangrado")
    private String tipoSangrado;

    @Column(name = "glasgow_apertura_ocular")
    private Integer glasgowAperturaOcular;

    @Column(name = "glasgow_apertura_motora")
    private Integer glasgowAperturaMotora;

    @Column(name = "glasgow_apertura_verbal")
    private Integer glasgowAperturaVerbal;

    // Relación ManyToOne
    /*@ManyToOne
    @JoinColumn(name = "id_par", nullable = false)
    private Participante participante;*/

    // Getters y Setters
   
  
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
   
	public Integer getIdDat() {
		return idDat;
	}

	public void setIdDat(Integer idDat) {
		this.idDat = idDat;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaInicioSintomas() {
        return fechaInicioSintomas;
    }

    public void setFechaInicioSintomas(LocalDate fechaInicioSintomas) {
        this.fechaInicioSintomas = fechaInicioSintomas;
    }

    public LocalDate getFechaTomaMuestra1() {
        return fechaTomaMuestra1;
    }

    public void setFechaTomaMuestra1(LocalDate fechaTomaMuestra1) {
        this.fechaTomaMuestra1 = fechaTomaMuestra1;
    }

    public LocalDate getFechaTomaMuestra2() {
        return fechaTomaMuestra2;
    }

    public void setFechaTomaMuestra2(LocalDate fechaTomaMuestra2) {
        this.fechaTomaMuestra2 = fechaTomaMuestra2;
    }

    public Boolean getFiebre() {
        return fiebre;
    }

    public void setFiebre(Boolean fiebre) {
        this.fiebre = fiebre;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public Boolean getMialgias() {
        return mialgias;
    }

    public void setMialgias(Boolean mialgias) {
        this.mialgias = mialgias;
    }

    public Boolean getCefalea() {
        return cefalea;
    }

    public void setCefalea(Boolean cefalea) {
        this.cefalea = cefalea;
    }

    public Boolean getDolorOcular() {
        return dolorOcular;
    }

    public void setDolorOcular(Boolean dolorOcular) {
        this.dolorOcular = dolorOcular;
    }

    public Boolean getDolorLumbar() {
        return dolorLumbar;
    }

    public void setDolorLumbar(Boolean dolorLumbar) {
        this.dolorLumbar = dolorLumbar;
    }

    public Boolean getErupcionCutanea() {
        return erupcionCutanea;
    }

    public void setErupcionCutanea(Boolean erupcionCutanea) {
        this.erupcionCutanea = erupcionCutanea;
    }

    public Boolean getConjuntivitis() {
        return conjuntivitis;
    }

    public void setConjuntivitis(Boolean conjuntivitis) {
        this.conjuntivitis = conjuntivitis;
    }

    public Boolean getNauseasVomitos() {
        return nauseasVomitos;
    }

    public void setNauseasVomitos(Boolean nauseasVomitos) {
        this.nauseasVomitos = nauseasVomitos;
    }

    public String getOtrosSintomas1() {
        return otrosSintomas1;
    }

    public void setOtrosSintomas1(String otrosSintomas1) {
        this.otrosSintomas1 = otrosSintomas1;
    }

    public String getOtrosSintomas2() {
        return otrosSintomas2;
    }

    public void setOtrosSintomas2(String otrosSintomas2) {
        this.otrosSintomas2 = otrosSintomas2;
    }

    public String getOtrosSintomas3() {
        return otrosSintomas3;
    }

    public void setOtrosSintomas3(String otrosSintomas3) {
        this.otrosSintomas3 = otrosSintomas3;
    }

    public String getOtrosSintomas4() {
        return otrosSintomas4;
    }

    public void setOtrosSintomas4(String otrosSintomas4) {
        this.otrosSintomas4 = otrosSintomas4;
    }

    public Boolean getDolorAbdominalIntenso() {
        return dolorAbdominalIntenso;
    }

    public void setDolorAbdominalIntenso(Boolean dolorAbdominalIntenso) {
        this.dolorAbdominalIntenso = dolorAbdominalIntenso;
    }

    public Boolean getDolorToracicoDisnea() {
        return dolorToracicoDisnea;
    }

    public void setDolorToracicoDisnea(Boolean dolorToracicoDisnea) {
        this.dolorToracicoDisnea = dolorToracicoDisnea;
    }

    public Boolean getDerrameSeroso() {
        return derrameSeroso;
    }

    public void setDerrameSeroso(Boolean derrameSeroso) {
        this.derrameSeroso = derrameSeroso;
    }

    public Boolean getHipotermia() {
        return hipotermia;
    }

    public void setHipotermia(Boolean hipotermia) {
        this.hipotermia = hipotermia;
    }

    public Boolean getDiuresisDisminuida() {
        return diuresisDisminuida;
    }

    public void setDiuresisDisminuida(Boolean diuresisDisminuida) {
        this.diuresisDisminuida = diuresisDisminuida;
    }

    public Boolean getHepatomegalia() {
        return hepatomegalia;
    }

    public void setHepatomegalia(Boolean hepatomegalia) {
        this.hepatomegalia = hepatomegalia;
    }

    public Boolean getIctericia() {
        return ictericia;
    }

    public void setIctericia(Boolean ictericia) {
        this.ictericia = ictericia;
    }

    public Boolean getEstadoMentalAlterado() {
        return estadoMentalAlterado;
    }

    public void setEstadoMentalAlterado(Boolean estadoMentalAlterado) {
        this.estadoMentalAlterado = estadoMentalAlterado;
    }

    public Boolean getHematocritoIncrementado() {
        return hematocritoIncrementado;
    }

    public void setHematocritoIncrementado(Boolean hematocritoIncrementado) {
        this.hematocritoIncrementado = hematocritoIncrementado;
    }

    public Boolean getPulsoIndetectable() {
        return pulsoIndetectable;
    }

    public void setPulsoIndetectable(Boolean pulsoIndetectable) {
        this.pulsoIndetectable = pulsoIndetectable;
    }

    public Boolean getExtremidadesFrias() {
        return extremidadesFrias;
    }

    public void setExtremidadesFrias(Boolean extremidadesFrias) {
        this.extremidadesFrias = extremidadesFrias;
    }

    public Boolean getDifPresionArterial() {
        return difPresionArterial;
    }

    public void setDifPresionArterial(Boolean difPresionArterial) {
        this.difPresionArterial = difPresionArterial;
    }

    public Boolean getCompromisoOrganos() {
        return compromisoOrganos;
    }

    public void setCompromisoOrganos(Boolean compromisoOrganos) {
        this.compromisoOrganos = compromisoOrganos;
    }

    public String getTipoCompromisoOrganos() {
        return tipoCompromisoOrganos;
    }

    public void setTipoCompromisoOrganos(String tipoCompromisoOrganos) {
        this.tipoCompromisoOrganos = tipoCompromisoOrganos;
    }

    public Boolean getSangradoGrave() {
        return sangradoGrave;
    }

    public void setSangradoGrave(Boolean sangradoGrave) {
        this.sangradoGrave = sangradoGrave;
    }

    public String getTipoSangrado() {
        return tipoSangrado;
    }

    public void setTipoSangrado(String tipoSangrado) {
        this.tipoSangrado = tipoSangrado;
    }

    public Integer getGlasgowAperturaOcular() {
        return glasgowAperturaOcular;
    }

    public void setGlasgowAperturaOcular(Integer glasgowAperturaOcular) {
        this.glasgowAperturaOcular = glasgowAperturaOcular;
    }

    public Integer getGlasgowAperturaMotora() {
        return glasgowAperturaMotora;
    }

    public void setGlasgowAperturaMotora(Integer glasgowAperturaMotora) {
        this.glasgowAperturaMotora = glasgowAperturaMotora;
    }

    public Integer getGlasgowAperturaVerbal() {
        return glasgowAperturaVerbal;
    }

    public void setGlasgowAperturaVerbal(Integer glasgowAperturaVerbal) {
        this.glasgowAperturaVerbal = glasgowAperturaVerbal;
    }
/* 
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }*/
}