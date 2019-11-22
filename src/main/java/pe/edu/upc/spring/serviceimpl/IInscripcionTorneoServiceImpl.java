package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.IInscripcionTorneoDAO;
import pe.edu.upc.spring.service.IInscripcionTorneoService;

@Service

public class IInscripcionTorneoServiceImpl implements IInscripcionTorneoService {

	@Autowired
	private IInscripcionTorneoDAO dInscripcionTorneo;
	
	@Override
	@Transactional
	public boolean insertar(InscripcionTorneo itorneo) {
		
		
		InscripcionTorneo objUsuario =dInscripcionTorneo.save(itorneo);
		
		
		if(objUsuario==null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional
	public boolean modificar(InscripcionTorneo itorneo) {
		boolean flag=false;
		
		try {
			dInscripcionTorneo.save(itorneo);
			flag=true;
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idITorneo) {
		dInscripcionTorneo.deleteById(idITorneo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<InscripcionTorneo> listarId(int idTorneo){
		return dInscripcionTorneo.findById(idTorneo);	
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public List<InscripcionTorneo> listar(){
		return dInscripcionTorneo.findAll();
	}
	
	@Override
	public List<InscripcionTorneo> buscarTorneoPorUsuario(Usuario usuario){		
		return dInscripcionTorneo.buscarTorneoPorUsuario(usuario);
	}
	
	@Override
	public List<InscripcionTorneo> buscarTorneoPorTorneo(Torneo torneo){		
		return dInscripcionTorneo.buscarTorneoPorTorneo(torneo);
	}
	
}
