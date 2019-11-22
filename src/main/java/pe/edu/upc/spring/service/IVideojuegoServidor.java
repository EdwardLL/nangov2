package pe.edu.upc.spring.service;
import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Videojuego;

public interface IVideojuegoServidor {
	List<Videojuego> listar();
	List<Videojuego> buscarTorneoPorN(String nombreVideojuego);
}
