package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.InscripcionTorneo;

@Repository
public interface IInscripcionTorneoDAO extends JpaRepository<InscripcionTorneo, Integer> {

	@Query("from InscripcionTorneo IT where IT.usuario like '%:usuario%'")
	List<InscripcionTorneo> buscarTorneoPorUsuario(@Param("usuario")String usuario);
}
