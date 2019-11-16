package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Ciudad;
import pe.edu.upc.spring.repository.ICiudadDao;
import pe.edu.upc.spring.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService {
	
	@Autowired
	private ICiudadDao dCiudad;
	
	@Override
	@Transactional(readOnly=true)
	public List<Ciudad> listar(){
		return dCiudad.findAll();
	}
	
}
