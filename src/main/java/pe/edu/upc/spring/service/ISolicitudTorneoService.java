package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.SolicitudTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;

public interface ISolicitudTorneoService {
	
	public boolean insertar(SolicitudTorneo Storneo);
	public boolean modificar(SolicitudTorneo Storneo);
	public void eliminar(int idTorneo);
	public Optional<SolicitudTorneo> listarId(int idTorneo);
	List<SolicitudTorneo> listar();
	List<SolicitudTorneo> buscarTorneoPorUsuario(Usuario usuario);
	List<SolicitudTorneo> buscarTorneoPorTorneo(Torneo torneo);
}
