package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.Videojuego;

@Repository
public interface IVideojuegoDAO extends JpaRepository<Videojuego, Integer>{
	
	@Query("from Videojuego v where v.nombreVideojuego= ?1" )
	List<Videojuego> buscarTorneoPorN(@Param("nombreVideojuego")String nombreVideojuego);

}
