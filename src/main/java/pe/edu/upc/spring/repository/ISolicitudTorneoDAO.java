package pe.edu.upc.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.SolicitudTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;

@Repository
public interface ISolicitudTorneoDAO extends JpaRepository<SolicitudTorneo, Integer>  {

	@Query("from SolicitudTorneo s where s.usuario= ?1")
	List<SolicitudTorneo> buscarTorneoPorUsuario(@Param("usuario")Usuario usuario);
	
	@Query("from SolicitudTorneo s where s.torneo= ?1")
	List<SolicitudTorneo> buscarTorneoPorTorneo(@Param("torneo")Torneo torneo);
}
