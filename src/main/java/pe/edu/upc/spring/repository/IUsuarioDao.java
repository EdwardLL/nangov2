package pe.edu.upc.spring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario,Integer> {

	@Query("from Usuario u where u.EmailUsuario like %:EmailUsuario%")
	List<Usuario> buscarEmailUsuario(@Param("EmailUsuario")String EmailUsuario);
	
	@Query("from Usuario u where u.IDUsuario=?1")
	List<Usuario> buscarUsuarioID(@Param("IDUsuario")int IDUsuario);
	
	@Query("from Usuario u where u.EmailUsuario like %:EmailUsuario% and u.ClvUsuario like %:ClvUsuario%")
	List<Usuario> buscarEmailContrasenia(@Param("EmailUsuario")String EmailUsuario,@Param("ClvUsuario")String ClvUsuario);
	
	@Query("from Usuario u where u.EmailUsuario like %:EmailUsuario%")
	Optional<Usuario> finByEmail(@Param("EmailUsuario")String EmailUsuario);
	
}
