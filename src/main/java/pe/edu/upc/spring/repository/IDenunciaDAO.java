package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Denuncia;


@Repository
public interface IDenunciaDAO extends JpaRepository<Denuncia,Integer> {
	
	@Query("from Denuncia d where d.usuario like '%:usuario%'")
	List<Denuncia> buscarPorUsuario(@Param("usuario")String usuario);
		
}