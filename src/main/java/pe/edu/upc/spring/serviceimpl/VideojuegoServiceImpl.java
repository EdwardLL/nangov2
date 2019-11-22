package pe.edu.upc.spring.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Servidor;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Videojuego;
import pe.edu.upc.spring.repository.IVideojuegoDAO;
import pe.edu.upc.spring.service.IVideojuegoServidor;

@Service
public class VideojuegoServiceImpl implements IVideojuegoServidor {
	
	@Autowired
	private IVideojuegoDAO dVideojuego;
	
	@Override
	@Transactional(readOnly=true)
	public List<Videojuego> listar(){
		return dVideojuego.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public 	List<Videojuego> buscarTorneoPorN(String nombreVideojuego){
		return dVideojuego.buscarTorneoPorN(nombreVideojuego);
	}
}
