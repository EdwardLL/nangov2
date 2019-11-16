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
@Table(name="Servidor")
public class Servidor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServidor;
	
	private String nombreServidor;
	
	@ManyToOne
	@JoinColumn(name="idCiudad",nullable=false)
	private Ciudad ciudad;

	public Servidor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Servidor(int idServidor, String nombreServidor,Ciudad ciudad) {
		super();
		this.idServidor = idServidor;
		this.nombreServidor = nombreServidor;
		this.ciudad=ciudad;
	}

	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}

	public String getNombreServidor() {
		return nombreServidor;
	}

	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
