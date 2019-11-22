package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;

public interface IInscripcionTorneoService {

	public boolean insertar(InscripcionTorneo torneo);
	public boolean modificar(InscripcionTorneo torneo);
	public void eliminar(int idTorneo);
	public Optional<InscripcionTorneo> listarId(int idTorneo);
	List<InscripcionTorneo> listar();
	List<InscripcionTorneo> buscarTorneoPorUsuarioTorneo(Usuario usuario,Torneo torneo);
	List<InscripcionTorneo> buscarTorneoPorTorneo(Torneo torneo);
}
