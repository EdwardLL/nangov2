package pe.edu.upc.spring.service;

import java.util.List;


import pe.edu.upc.spring.model.Denuncia;
import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.Torneo;

public interface IDenunciaService {
	
	public boolean insertar(Denuncia denuncia);
	public void eliminar(int idTorneo);
	List<Denuncia> listar();
	List<Denuncia> buscarPorUsuario(String usuario);
}
