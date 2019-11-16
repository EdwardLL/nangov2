package pe.edu.upc.spring.service;

import java.util.List;


import pe.edu.upc.spring.model.Denuncia;

public interface IDenunciaService {

	List<Denuncia> listar();
	List<Denuncia> buscarPorUsuario(String usuario);
}
