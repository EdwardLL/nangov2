package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.SolicitudTorneo;
import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.ITorneoService;
import pe.edu.upc.spring.service.ICiudadService;
import pe.edu.upc.spring.service.IInscripcionTorneoService;
import pe.edu.upc.spring.service.ISolicitudTorneoService;

import pe.edu.upc.spring.service.IVideojuegoServidor;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {


	@Autowired
	private IUsuarioService uService;
	@Autowired
	private ICiudadService cService;
	@Autowired
	private ITorneoService tService;
	@Autowired
	private IVideojuegoServidor vService;
	@Autowired
	private IInscripcionTorneoService itService;
	@Autowired
	private ISolicitudTorneoService stService;
	
	String ND="Dota 2";
	String NL="League of legends";
	
	Usuario user = new Usuario();
	String s= "Pendiente";
	String s2= "Aprobado";
	String s3= "Finalizado";
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaUsuario", uService.listar());

		return "listUsuarios";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("usuario", new Usuario());		
		model.addAttribute("ciudades",cService.listar());
		return "usuario";
	}
	
	@RequestMapping("/irNANGO")
	public String irNANGO(Model model) {
		model.addAttribute("listaV",vService.listar());
		model.addAttribute("videojuegosD",vService.buscarTorneoPorN(ND));
		model.addAttribute("videojuegosL",vService.buscarTorneoPorN(NL));
		return "NANGO";
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Usuario objUsuario,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			return "usuario";
		}
		else {
			boolean flag = uService.insertar(objUsuario);
			if(flag) {
				return "redirect:/usuario/irNANGO";}
			else {
				model.addAttribute("mensaje", "ocurrio un roche");
				return "usuario";}
			
		}
	}
	
	@RequestMapping("/registrarAdmi")
	public String registrarAdmi(@ModelAttribute @Valid Usuario objUsuario,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			return "usuarioDeAdmin";
		}
		else {
			boolean flag = uService.insertar(objUsuario);
			if(flag) {		
				;
				return "redirect:/usuario/listar";
		     }
			else {
				model.addAttribute("mensaje", "ocurrio un roche");
				return "usuarioDeAdmin";}
			
		}
	}

	
	@RequestMapping("/listarId")
	public String listarId(Map<String,Object>model, @ModelAttribute Usuario usuario) {
		uService.listarId(usuario.getIDUsuario());
		return "listUsuarios";
	}

	
	@RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
				
		Optional<Usuario> objUsuario =uService.listarId(id);
		
		
		if(objUsuario==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un roche");
			return "redirect:/usuario/listar";
		}
		else {
			model.addAttribute("ciudades",cService.listar());
			model.addAttribute("usuario",objUsuario);
			return "usuarioDeAdmin";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object>model,@RequestParam(value="id")Integer id) {
		
		try {
			if(id!=null && id>0) {
				uService.eliminar(id);
				model.put("listaUsuarios",uService.listar());
			}
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		   model.put("mensaje", "no se puede eliminar un usuario asignado");
		   model.put("listaUsuarios",uService.listar());
		}
		
		return "redirect:/usuario/listar";
	}
	
	@RequestMapping("/validarUsuarioInscripcioATorneo")
	public String validarUsuario(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException {	
		List<Usuario> Usuario ;
		usuario.setEmailUsuario(usuario.getEmailUsuario());
		usuario.setClvUsuario(usuario.getClvUsuario());
		Usuario=uService.buscarPorEmailContrasenia(usuario.getEmailUsuario(),usuario.getClvUsuario());				
		if (Usuario ==null) {
			model.put("mensaje", "No se encontro");
			return "ingresarInscribirseATorneo";
		}
		else {
		model.put("InscripcionTorneo", new InscripcionTorneo());		
		model.put("torneos",tService.buscarTorneoPorAprobado(s2, s3));
		model.put("usuarioN", Usuario);
		return "InscripcionATorneo";
		}
	}
	
	
	@RequestMapping("/validarUsuarioSolicitarTorneo")
	public String solicitarTorneo(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException {	
		List<Usuario> Usuario2 ;
		usuario.setEmailUsuario(usuario.getEmailUsuario());
		usuario.setClvUsuario(usuario.getClvUsuario());
		Usuario2=uService.buscarPorEmailContrasenia(usuario.getEmailUsuario(),usuario.getClvUsuario());				
		if (Usuario2 ==null) {
			model.put("mensaje", "No se encontro");
			return "ingresarInscribirseATorneo";
		}
		else {
		model.put("SolicitudTorneo", new SolicitudTorneo());		
		model.put("torneos",tService.buscarTorneoPorestadCreaTorneo(s));
		model.put("usuarioN", Usuario2);
		return "SolicitarTorneo";
		}
	}
	

	@RequestMapping("/validarUsuarioMisTorneos")
	public String misTorneos(Map<String, Object> model, @ModelAttribute Usuario uSuario) throws ParseException {	
		List<Usuario> Usuario2 ;
		List<InscripcionTorneo> ITLista;
		ITLista=itService.buscarTorneoPorUsuario(uSuario);
		uSuario.setEmailUsuario(uSuario.getEmailUsuario());
		uSuario.setClvUsuario(uSuario.getClvUsuario());
		Usuario2=uService.buscarPorEmailContrasenia(uSuario.getEmailUsuario(),uSuario.getClvUsuario());				
		if (Usuario2 ==null) {
			model.put("mensaje", "No se encontro");
			return "ingresarMisTorneos";
		}
		else {	
		model.put("MisTorneos",ITLista);
		return "MisTorneos";
		}
	}
	
	@RequestMapping("/iringresarInscribirseATorneo")
	public String iringresarInscribirseATorneo(Model model) {
		model.addAttribute("usuario", new Usuario());	
		return "ingresarInscribirseATorneo";
	}
	
	@RequestMapping("/iringresarSolicitarTorneo")
	public String iringresarSolicitarTorneo(Model model) {
		model.addAttribute("usuario", new Usuario());	
		return "ingresarSolicitarTorneo";
	}
	
	@RequestMapping("/iringresarMisTorneos")
	public String iringresarMisTorneos(Model model) {
		model.addAttribute("usuario", new Usuario());	
		return "ingresarMisTorneos";
	}
	
}


