package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Usuario;

public interface IUsuarioService {

	public boolean insertar(Usuario usuario);
	public boolean modificar(Usuario usuario);
	public void eliminar(int idUsuario);
	public Optional<Usuario> buscarId(int idUsuario);
	public Optional<Usuario> listarId(int idUsuario);
	public Optional<Usuario> buscarEmail(String email);
	public int Encontrado(String mail,String clv);
	List<Usuario> listar();
	List<Usuario> buscarPorEmail(String EmailUsuario);
	List<Usuario> buscarPorEmailContrasenia(String nombreUsuario,String contra);
	List<Usuario> buscarUsuarioID(int IDUsuario);
}
