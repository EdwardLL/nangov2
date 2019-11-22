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
@Table(name="Denuncia")

public class Denuncia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDenuncia;
	
	private String mensajeDenuncia;
	

	@ManyToOne
	@JoinColumn(name="IDUsuario",nullable=false)
	private Usuario usuario;
	
	public Denuncia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Denuncia(int idDenuncia, String mensajeDenuncia,Usuario usuario) {
		super();
		this.idDenuncia = idDenuncia;
		this.mensajeDenuncia = mensajeDenuncia;
		this.usuario = usuario;
	}

	public int getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	public String getMensajeDenuncia() {
		return mensajeDenuncia;
	}

	public void setMensajeDenuncia(String mensajeDenuncia) {
		this.mensajeDenuncia = mensajeDenuncia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}








