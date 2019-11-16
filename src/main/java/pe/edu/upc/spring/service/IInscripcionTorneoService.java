package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.InscripcionTorneo;

public interface IInscripcionTorneoService {

	public boolean insertar(InscripcionTorneo torneo);
	public boolean modificar(InscripcionTorneo torneo);
	public void eliminar(int idTorneo);
	public Optional<InscripcionTorneo> listarId(int idTorneo);
	List<InscripcionTorneo> listar();
	List<InscripcionTorneo> buscarTorneoPorUsuario(String usuario);
	
}
