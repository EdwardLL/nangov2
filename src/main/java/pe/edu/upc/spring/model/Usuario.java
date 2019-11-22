package pe.edu.upc.spring.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@Table(name="Usuario")

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDUsuario;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar vacio")
	private String NUsuario;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar vacio")
	@Email(regexp="^(.+)@(.+)$",message="Email invalido")
	private String EmailUsuario;
	
	@NotNull
	@Temporal(TemporalType.DATE) //permite trabajar fechas
	@Column(name="DBirth")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date DBirth;
	

	private int SaldUsuario;
	
	private String InsigUsuario;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar vacio")
	private String ClvUsuario;
	
    private String FUsuario;	
	
    @ManyToOne
	@JoinColumn(name="idCiudad",nullable=false)
	private Ciudad ciudad;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(int IDUsuario, String NUsuario, Date DBirth, int SaldUsuario,
			String InsigUsuario, String ClvUsuario, String FUsuario, Ciudad ciudad,String EmailUsuario) {
		super();
		this.IDUsuario=IDUsuario;
		this.NUsuario=NUsuario;
		this.DBirth=DBirth;
		this.SaldUsuario=SaldUsuario;
		this.InsigUsuario=InsigUsuario;
		this.ClvUsuario=ClvUsuario;
		this.FUsuario=FUsuario;
		this.ciudad=ciudad;
		this.EmailUsuario=EmailUsuario;
	}

	public int getIDUsuario() {
		return IDUsuario;
	}

	public void setIDUsuario(int iDUsuario) {
		IDUsuario = iDUsuario;
	}

	public String getNUsuario() {
		return NUsuario;
	}

	public void setNUsuario(String nUsuario) {
		NUsuario = nUsuario;
	}

	public String getEmailUsuario() {
		return EmailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		EmailUsuario = emailUsuario;
	}

	public Date getDBirth() {
		return DBirth;
	}

	public void setDBirth(Date dBirth) {
		DBirth = dBirth;
	}

	public int getSaldUsuario() {
		return SaldUsuario;
	}

	public void setSaldUsuario(int saldUsuario) {
		SaldUsuario = saldUsuario;
	}

	public String getInsigUsuario() {
		return InsigUsuario;
	}

	public void setInsigUsuario(String insigUsuario) {
		InsigUsuario = insigUsuario;
	}

	public String getClvUsuario() {
		return ClvUsuario;
	}

	public void setClvUsuario(String clvUsuario) {
		ClvUsuario = clvUsuario;
	}

	public String getFUsuario() {
		return FUsuario;
	}

	public void setFUsuario(String fUsuario) {
		FUsuario = fUsuario;
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


