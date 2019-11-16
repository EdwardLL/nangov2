package pe.edu.upc.spring.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Ciudad")

public class Ciudad {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCiudad;
	
	private String nombreCiudad;
	
	@ManyToOne
	@JoinColumn(name="idPais",nullable=false)
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name="idZonaHoraria",nullable=false)
	private ZonaHoraria zonahoraria;

	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ciudad(int idCiudad,String nombreCiudad, Pais pais,ZonaHoraria zonahoraria) {
		super();
		this.idCiudad=idCiudad;
		this.nombreCiudad=nombreCiudad;
		this.pais=pais;
		this.zonahoraria=zonahoraria;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public ZonaHoraria getZonahoraria() {
		return zonahoraria;
	}

	public void setZonahoraria(ZonaHoraria zonahoraria) {
		this.zonahoraria = zonahoraria;
	}
	

}


