package pe.edu.upc.spring.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Videojuego")

public class Videojuego  implements Serializable{
	  private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idVideojuego;
		
		private String nombreVideojuego;
		private int numcompetidores;

		public Videojuego() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Videojuego(int idVideojuego, String nombreVideojuego,int numcompetidores) {
			super();
			this.idVideojuego = idVideojuego;
			this.nombreVideojuego = nombreVideojuego;
			this.numcompetidores = numcompetidores;
		}


		public int getIdVideojuego() {
			return idVideojuego;
		}


		public void setIdVideojuego(int idVideojuego) {
			this.idVideojuego = idVideojuego;
		}


		public String getNombreVideojuego() {
			return nombreVideojuego;
		}


		public void setNombreVideojuego(String nombreVideojuego) {
			this.nombreVideojuego = nombreVideojuego;
		}


		public int getNumcompetidores() {
			return numcompetidores;
		}


		public void setNumcompetidores(int numcompetidores) {
			this.numcompetidores = numcompetidores;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		
}
