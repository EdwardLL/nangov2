package pe.edu.upc.spring.model;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="Torneo")

public class Torneo implements Serializable {
	

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTorneo;
	private String nombreTorneo;
	
	@NotNull
	@Temporal(TemporalType.DATE) //permite trabajar fechas
	@Column(name="fechaInicio")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaInicio;
	
	@NotNull
	@Temporal(TemporalType.DATE) //permite trabajar fechas
	@Column(name="FechaFin")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FechaFin;
	
	@NotNull
	@Temporal(TemporalType.TIME) //permite trabajar fechas
	@Column(name="HoraInicio")
	@DateTimeFormat(pattern="HH:mm")
	private Date HoraInicio;
	
	@NotNull
	@Temporal(TemporalType.TIME) //permite trabajar fechas
	@Column(name="HoraFin")
	@DateTimeFormat(pattern="HH:mm")
	private Date HoraFin;
	@NotNull
	private int costoTorneo;
	@NotNull
	private String premioTorneo;
	private String platafTorneo;

	private int vacantes;
	private String estadCreaTorneo;

	@ManyToOne
	@JoinColumn(name="idVideojuego",nullable=false)
	private Videojuego videojuego;
	
    private String estadTranscuTorneo;
    private String modoTorneo;
    
    @ManyToOne
   	@JoinColumn(name="idServidor",nullable=false)
   	private Servidor servidor;

    public Torneo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Torneo(int idTorneo, String nombreTorneo, Date fechaInicio, int costoTorneo,
			String premioTorneo, String platafTorneo, int vacantes, String estadCreaTorneo,
			Videojuego videojuego,String modoTorneo,Servidor servidor,Date hI,Date hF,Date fechaFin,String estadTranscuTorneo) {
		super();
		this.idTorneo=idTorneo;
		this.nombreTorneo=nombreTorneo;
		this.fechaInicio=fechaInicio;
		this.costoTorneo=costoTorneo;
		this.premioTorneo=premioTorneo;
		this.platafTorneo=platafTorneo;
		this.vacantes=vacantes;
		this.estadCreaTorneo=estadCreaTorneo;
		this.videojuego=videojuego;
		this.modoTorneo=modoTorneo;
		this.servidor=servidor;
		this.HoraInicio=hI;
		this.HoraFin=hF;
		this.FechaFin=fechaFin;
		this.estadTranscuTorneo=estadTranscuTorneo;
	}

    
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}

	public Date getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		HoraInicio = horaInicio;
	}

	public Date getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(Date horaFin) {
		HoraFin = horaFin;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	
	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public String getNombreTorneo() {
		return nombreTorneo;
	}

	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}

	

	public int getCostoTorneo() {
		return costoTorneo;
	}

	public void setCostoTorneo(int costoTorneo) {
		this.costoTorneo = costoTorneo;
	}

	public String getPremioTorneo() {
		return premioTorneo;
	}

	public void setPremioTorneo(String premioTorneo) {
		this.premioTorneo = premioTorneo;
	}

	public String getPlatafTorneo() {
		return platafTorneo;
	}

	public void setPlatafTorneo(String platafTorneo) {
		this.platafTorneo = platafTorneo;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public String getEstadCreaTorneo() {
		return estadCreaTorneo;
	}

	public void setEstadCreaTorneo(String estadCreaTorneo) {
		this.estadCreaTorneo = estadCreaTorneo;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public String getEstadTranscuTorneo() {
		return estadTranscuTorneo;
	}

	public void setEstadTranscuTorneo(String estadTranscuTorneo) {
		this.estadTranscuTorneo = estadTranscuTorneo;
	}

	public String getModoTorneo() {
		return modoTorneo;
	}

	public void setModoTorneo(String modoTorneo) {
		this.modoTorneo = modoTorneo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}





