package pe.edu.upc.spring.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Denuncia;
import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.repository.IDenunciaDAO;
import pe.edu.upc.spring.service.IDenunciaService;

@Service
public class DenunciaServiceImpl  implements IDenunciaService {

	@Autowired
	private IDenunciaDAO dDenuncia;
	
	@Override
	@Transactional(readOnly=true)
	public List<Denuncia> listar(){
		return dDenuncia.findAll();
	}
	
	@Override
	@Transactional
	public void eliminar(int idITorneo) {
		dDenuncia.deleteById(idITorneo);
	}
	
	@Override
	@Transactional
	public boolean insertar(Denuncia dTorneo) {
		
		
		Denuncia objUsuario =dDenuncia.save(dTorneo);
			
		if(objUsuario==null)
			return false;
		else
			return true;
	}
	
	@Override
	public List<Denuncia> buscarPorUsuario(String Email){		
		return dDenuncia.buscarPorUsuario(Email);
	}
	
}
