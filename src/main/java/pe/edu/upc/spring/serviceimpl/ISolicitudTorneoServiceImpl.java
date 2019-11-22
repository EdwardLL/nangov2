package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SolicitudTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.ISolicitudTorneoDAO;
import pe.edu.upc.spring.service.ISolicitudTorneoService;

@Service
public class ISolicitudTorneoServiceImpl implements ISolicitudTorneoService  {
	
	@Autowired
	private ISolicitudTorneoDAO dSolicitudTorneo;
	
	@Override
	@Transactional
	public boolean insertar(SolicitudTorneo storneo) {
		SolicitudTorneo objUsuario =dSolicitudTorneo.save(storneo);
		if(objUsuario==null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional
	public boolean modificar(SolicitudTorneo storneo) {
		boolean flag=false;
		
		try {
			dSolicitudTorneo.save(storneo);
			flag=true;
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int storneo) {
		dSolicitudTorneo.deleteById(storneo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<SolicitudTorneo> listarId(int idTorneo){
		return dSolicitudTorneo.findById(idTorneo);	
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public List<SolicitudTorneo> listar(){
		return dSolicitudTorneo.findAll();
	}
	
	@Override
	public List<SolicitudTorneo> buscarTorneoPorUsuario(Usuario usuario){		
		return dSolicitudTorneo.buscarTorneoPorUsuario(usuario);
	}
	
	@Override
	public List<SolicitudTorneo> buscarTorneoPorTorneo(Torneo torneo){		
		return dSolicitudTorneo.buscarTorneoPorTorneo(torneo);
	}
	
}
