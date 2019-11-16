package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Servidor;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Videojuego;

import java.util.Date;
public interface ITorneoService {

	public boolean insertar(Torneo torneo);
	public boolean modificar(Torneo torneo);
	public void eliminar(int idTorneo);
	public Optional<Torneo> listarId(int idTorneo);
	List<Torneo> listar();
	List<Torneo> buscarTorneoPorVideojuego(Videojuego videojuego);
	List<Torneo> buscarTorneoPorCosto(int costoTorneo);
	List<Torneo> buscarTorneoPorEstadoDeTranscurso(String estadTranscuTorneo);
	List<Torneo> buscarTorneoPorFechaInicio(Date fechaInicio);
	List<Torneo> buscarTorneoPorNombre(String nombreTorneo);
	List<Torneo> buscarTorneoFiltroTotal(Videojuego videojuego,String modoTorneo,Servidor servidor,String transcurso);
}
