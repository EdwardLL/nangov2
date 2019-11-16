package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")

public class Administrador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrador;
	
	private String nombreAdministrador;

	private String clvAdministrador;
	private String emailAdministrador;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Administrador(int idAdministrador, String nombreAdministrador,String clvAdministrador,String emailAdministrador) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombreAdministrador = nombreAdministrador;
		this.clvAdministrador = clvAdministrador;
		this.emailAdministrador = emailAdministrador;
	}


	public int getIdAdministrador() {
		return idAdministrador;
	}


	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}


	public String getNombreAdministrador() {
		return nombreAdministrador;
	}


	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}


	public String getClvAdministrador() {
		return clvAdministrador;
	}


	public void setClvAdministrador(String clvAdministrador) {
		this.clvAdministrador = clvAdministrador;
	}


	public String getEmailAdministrador() {
		return emailAdministrador;
	}


	public void setEmailAdministrador(String emailAdministrador) {
		this.emailAdministrador = emailAdministrador;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
