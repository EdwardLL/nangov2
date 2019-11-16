package pe.edu.upc.spring.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Servidor;
import pe.edu.upc.spring.repository.IServidorDAO;
import pe.edu.upc.spring.service.IServidorService;

@Service
public class ServidorServiceImpl  implements IServidorService{
	
	@Autowired
	private IServidorDAO dServidor;
	
	@Override
	@Transactional(readOnly=true)
	public List<Servidor> listar(){
		return dServidor.findAll();
	}
	

}
