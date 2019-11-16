package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Servidor;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Videojuego;
import pe.edu.upc.spring.repository.ITorneoDAO;
import pe.edu.upc.spring.service.ITorneoService;
import java.util.Date;
@Service
public class TorneoServiceImpl implements ITorneoService{

	@Autowired
	private ITorneoDAO dTorneo;
	
	@Override
	@Transactional
	public boolean insertar(Torneo torneo) {
		Torneo objUsuario =dTorneo.save(torneo);
		if(objUsuario==null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional
	public boolean modificar(Torneo torneo) {
		boolean flag=false;
		
		try {
			dTorneo.save(torneo);
			flag=true;
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idTorneo) {
		dTorneo.deleteById(idTorneo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Torneo> listarId(int idTorneo){
		return dTorneo.findById(idTorneo);	
	}
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> listar(){
		return dTorneo.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> buscarTorneoPorVideojuego(Videojuego videojuego){		
		return dTorneo.buscarTorneoPorVideojuego(videojuego);
	}	
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> buscarTorneoPorCosto(int costo){		
		return dTorneo.buscarTorneoPorCosto(costo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> buscarTorneoPorEstadoDeTranscurso(String EstadoTranscurs){		
		return dTorneo.buscarTorneoPorEstadoDeTranscurso(EstadoTranscurs);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> buscarTorneoPorFechaInicio(Date fechaInicio){		
		return dTorneo.buscarTorneoPorFechaInicio(fechaInicio);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> buscarTorneoPorNombre(String nombreTorneo){
		return dTorneo.buscarTorneoPorNombre(nombreTorneo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Torneo> buscarTorneoFiltroTotal(Videojuego videojuego,String modoTorneo,Servidor servidor,String transcurso){
		return dTorneo.buscarTorneoFiltroTotal(videojuego,modoTorneo,servidor,transcurso);
	}
	
}
