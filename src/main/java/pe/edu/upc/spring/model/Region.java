package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Region")

public class Region implements Serializable {

     private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRegion;
	
	private String nombreRegion;

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(int idRegion, String nombreReg) {
		super();
		this.idRegion = idRegion;
		this.nombreRegion = nombreReg;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}

