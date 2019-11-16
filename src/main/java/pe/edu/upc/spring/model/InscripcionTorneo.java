package pe.edu.upc.spring.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name="InscripcionTorneo")

public class InscripcionTorneo  implements Serializable{

	 private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idInscripcionTorneo;

	    @ManyToOne
		@JoinColumn(name="idTorneo",nullable=false)
		private Torneo torneo;
	    
	    @ManyToOne
		@JoinColumn(name="IDUsuario",nullable=false)
		private Usuario usuario;
	    
	    @NotNull
		@Past(message="No puedes seleccionar un dia que todavia NO existe")
		@Temporal(TemporalType.DATE) //permite trabajar fechas
		@Column(name="fechaInscripcion")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date fechaInscripcion;

	    public InscripcionTorneo() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public InscripcionTorneo(int idInscripcionTorneo, Torneo torneo,Usuario usuario, Date fechaInscripcion) {
			super();
			this.idInscripcionTorneo=idInscripcionTorneo;
			this.torneo=torneo;
			this.usuario=usuario;
			this.fechaInscripcion=fechaInscripcion;
		}

	    
		public int getIdInscripcionTorneo() {
			return idInscripcionTorneo;
		}

		public void setIdInscripcionTorneo(int idInscripcionTorneo) {
			this.idInscripcionTorneo = idInscripcionTorneo;
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

		public Date getFechaInscripcion() {
			return fechaInscripcion;
		}

		public void setFechaInscripcion(Date fechaInscripcion) {
			this.fechaInscripcion = fechaInscripcion;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    
}







