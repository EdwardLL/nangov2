package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.IUsuarioDao;
import pe.edu.upc.spring.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao dUsuario;
	
	@Override
	@Transactional
	public boolean insertar(Usuario usuario) {
		Usuario objUsuario =dUsuario.save(usuario);
		if(objUsuario==null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional
	public boolean modificar(Usuario usuario) {
		boolean flag=false;
		
		try {
			dUsuario.save(usuario);
			flag=true;
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idUsuario) {
		dUsuario.deleteById(idUsuario);
	}
	
	@Override
	public Optional<Usuario> buscarId(int idUsuario){
		return dUsuario.findById(idUsuario);	
	}
	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> listarId(int idUsuario){
		return dUsuario.findById(idUsuario);	
	}
	
	
	@Override
	public Optional<Usuario> buscarEmail(String email){
		return dUsuario.finByEmail(email);	
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> listar(){
		return dUsuario.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> buscarUsuarioID(int IDUsuario){
		return dUsuario.buscarUsuarioID(IDUsuario);
	}
	
	
	@Override
	public List<Usuario> buscarPorEmail(String Email){		
		return dUsuario.buscarEmailUsuario(Email);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> buscarPorEmailContrasenia(String Email,String clave){		
		return dUsuario.buscarEmailContrasenia(Email,clave);
	}
	
	@Override
	public int Encontrado(String mail,String clv){	
		
		if(dUsuario.buscarEmailContrasenia(mail,clv)!=null)
		{
			return 1;
		}
		else
			return 0;
	}
	
}
