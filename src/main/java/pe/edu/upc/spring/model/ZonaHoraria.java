package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ZonaHoraria")
public class ZonaHoraria implements Serializable {

	
   private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZonaHoraria;
	
	private String nombreZonaHoraria;
	

	public ZonaHoraria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ZonaHoraria(int idZonaHoraria, String nombreZona) {
		super();
		this.idZonaHoraria = idZonaHoraria;
		this.nombreZonaHoraria = nombreZona;
	}


	public int getIdZonaHoraria() {
		return idZonaHoraria;
	}


	public void setIdZonaHoraria(int idZonaHoraria) {
		this.idZonaHoraria = idZonaHoraria;
	}


	public String getNombreZonaHoraria() {
		return nombreZonaHoraria;
	}


	public void setNombreZonaHoraria(String nombreZonaHoraria) {
		this.nombreZonaHoraria = nombreZonaHoraria;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}


