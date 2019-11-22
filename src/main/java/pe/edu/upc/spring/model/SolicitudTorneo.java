package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



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

	@ManyToOne
	@JoinColumn(name="IDUsuario",nullable=false)
	private Usuario usuario;
	
	private String mensjSolicitud;
	
	public SolicitudTorneo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SolicitudTorneo(int idSolicitud, String estadSolicitud, Torneo torneo, 
			 Usuario usuario,String mensjSolicitud) {
		super();
		this.idSolicitud=idSolicitud;
		this.estadSolicitud=estadSolicitud;
		this.torneo=torneo;
		this.usuario=usuario;
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


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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







