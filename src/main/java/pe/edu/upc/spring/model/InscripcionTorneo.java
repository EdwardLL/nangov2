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
	    
	 
	    public InscripcionTorneo() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public InscripcionTorneo(int idInscripcionTorneo, Torneo torneo,Usuario usuario) {
			super();
			this.idInscripcionTorneo=idInscripcionTorneo;
			this.torneo=torneo;
			this.usuario=usuario;
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



		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    
}







