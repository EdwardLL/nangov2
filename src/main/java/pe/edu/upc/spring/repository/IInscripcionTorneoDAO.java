package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;

@Repository
public interface IInscripcionTorneoDAO extends JpaRepository<InscripcionTorneo, Integer> {

	@Query("from InscripcionTorneo IT where IT.usuario=?1 and IT.torneo=?2")
	List<InscripcionTorneo> buscarTorneoPorUsuarioTorneo(@Param("usuario")Usuario usuario,@Param("torneo")Torneo torneo);
	
	@Query("from InscripcionTorneo IT where IT.torneo=?1")
	List<InscripcionTorneo> buscarTorneoPorTorneo(@Param("torneo")Torneo torneo);
	
	@Query("from InscripcionTorneo IT where IT.torneo like '%:torneo%'")
	List<InscripcionTorneo> buscarTorneoPorID(@Param("idInscripcionTorneo")int idInscripcionTorneo);
	
}
