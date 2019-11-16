package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SolicitudTorneo")


public class SolicitudTorneo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolicitud;
	private String estadSolicitud;
	
	@ManyToOne
	@JoinColumn(name="idTorneo",nullable=false)
	private Torneo torneo;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE) //permite trabajar fechas
	@Column(name="fechaSolicitud")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaSolicitud;
	
	@ManyToOne
	@JoinColumn(name="IDUsuario",nullable=false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idAdministrador",nullable=false)
	private Administrador administrador;
	
	private String mensjSolicitud;
	
	public SolicitudTorneo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SolicitudTorneo(int idSolicitud, String estadSolicitud, Torneo torneo,Date fechaSolicitud, 
			 Usuario usuario,Administrador administrador,String mensjSolicitud) {
		super();
		this.idSolicitud=idSolicitud;
		this.estadSolicitud=estadSolicitud;
		this.torneo=torneo;
		this.fechaSolicitud=fechaSolicitud;
		this.usuario=usuario;
		this.administrador=administrador;
		this.mensjSolicitud=mensjSolicitud;
		
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getEstadSolicitud() {
		return estadSolicitud;
	}

	public void setEstadSolicitud(String estadSolicitud) {
		this.estadSolicitud = estadSolicitud;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getMensjSolicitud() {
		return mensjSolicitud;
	}

	public void setMensjSolicitud(String mensjSolicitud) {
		this.mensjSolicitud = mensjSolicitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}







