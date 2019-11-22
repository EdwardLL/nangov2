package pe.edu.upc.spring.repository;

import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Servidor;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Videojuego;

@Repository
public interface ITorneoDAO extends JpaRepository<Torneo, Integer>{

	@Query("from Torneo t where t.estadCreaTorneo= ?1" )
	List<Torneo> buscarTorneoPorECT(@Param("estadCreaTorneo")String estadCreaTorneo);
	
	@Query("from Torneo t where t.estadCreaTorneo= ?1  and t.estadTranscuTorneo!= ?2 ")
	List<Torneo> buscarTorneoPorAprobado(@Param("estadCreaTorneo")String estadCreaTorneo,@Param("estadTranscuTorneo")String estadTranscuTorneo);
	
	@Query("from Torneo t where t.costoTorneo= ?1")
	List<Torneo> buscarTorneoPorCosto(@Param("costoTorneo")int costoTorneo);
	
	@Query("from Torneo t where t.idTorneo= ?1")
	Torneo escogeTorneo(@Param("idTorneo")int idTorneo);
	
	@Query("from Torneo t where t.estadTranscuTorneo like %:estadTranscuTorneo%")
	List<Torneo> buscarTorneoPorEstadoDeTranscurso(@Param("estadTranscuTorneo")String estadTranscuTorneo);
	
	@Query("from Torneo t where t.fechaInicio like %:fechaInicio%")
	List<Torneo> buscarTorneoPorFechaInicio(@Param("fechaInicio")Date fechaInicio);
	
	@Query("from Torneo t where t.nombreTorneo like %:nombreTorneo%")
	List<Torneo> buscarTorneoPorNombre(@Param("nombreTorneo")String nombreTorneo);
	
	@Query("from Torneo t where t.videojuego= ?1 and t.modoTorneo= ?2 and t.servidor= ?3 and t.estadTranscuTorneo= ?4 ")
	List<Torneo> buscarTorneoFiltroTotal(@Param("videojuego")Videojuego videojuego,@Param("modoTorneo")String modoTorneo,
			@Param("servidor")Servidor servidor,@Param("estadTranscuTorneo")String estadTranscuTorneo);

}
