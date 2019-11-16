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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.ITorneoService;
import pe.edu.upc.spring.service.ICiudadService;
import pe.edu.upc.spring.service.IVideojuegoServidor;

@Controller
@RequestMapping("/usuario")
@SessionAttributes("/usuarioprueba")
public class UsuarioController {


	@Autowired
	private IUsuarioService uService;
	@Autowired
	private ICiudadService cService;
	@Autowired
	private ITorneoService tService;
	@Autowired
	private IVideojuegoServidor vService;

	Usuario usuarioValidado = new Usuario() ;
	
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaUsuario", uService.listar());

		return "listUsuarios";
	}
	
	
	
	@RequestMapping("/bienvenida")
	public String irIngreso(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "LandingPage";
	}
	
	@RequestMapping("/Header")
	public String Header(Map<String,Object> model) {
		return "header";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("usuario", new Usuario());		
		model.addAttribute("ciudades",cService.listar());
		return "usuario";
	}
	
	@RequestMapping("/irNANGO")
	public String irNANGO(Model model) {		
		model.addAttribute("usuarioprueba",usuarioValidado.getNUsuario());
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
				return "redirect:/usuario/bienvenida";}
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
	
	@RequestMapping("/validarUsuario")
	public String validarUsuario(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException {
		List<Usuario> listaUsuarios;
		usuario.setEmailUsuario(usuario.getEmailUsuario());
		usuario.setClvUsuario(usuario.getClvUsuario());
		listaUsuarios=uService.buscarPorEmailContrasenia(usuario.getEmailUsuario(),usuario.getClvUsuario());				
		if (listaUsuarios.isEmpty()) {
			model.put("mensaje", "No se encontro");
			return "LandingPage";
		}
		usuarioValidado=usuario;
		usuarioValidado.setNUsuario(usuario.getNUsuario());
		model.put("listaTorneo", tService.listar());
		return "redirect:/usuario/irNANGO";	
		
	}
	
	@RequestMapping("/obtenerDato")
    public String obtenerDato(@PathVariable int id, Model model, RedirectAttributes objRedir,@ModelAttribute Usuario usuario) {
		List<Usuario> listaUsuarios;
		usuario.setEmailUsuario(usuario.getEmailUsuario());
		usuario.setClvUsuario(usuario.getClvUsuario());
		listaUsuarios=uService.buscarPorEmailContrasenia(usuario.getEmailUsuario(),usuario.getClvUsuario());		
		
		if(listaUsuarios==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un roche");
			return "LandingPage";
		}
		else {
			model.addAttribute("ciudades",cService.listar());
			model.addAttribute("usuario",listaUsuarios);
			return "redirect:/usuario/irNANGO";
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
	
	
}


