package pe.edu.upc.spring.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.SolicitudTorneo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import pe.edu.upc.spring.model.Denuncia;
import pe.edu.upc.spring.service.IDenunciaService;
import pe.edu.upc.spring.service.IUsuarioService;


@Controller
@RequestMapping("/denuncia")
public class DenunciaController {
	
	@Autowired
	private IDenunciaService dService;
	@Autowired
	private IUsuarioService uService;
	
	String u="Inhabilitado";
	
	@RequestMapping("/denunciar/{id}")
    public String denunciar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
				
		Optional<Usuario> objUsuario =uService.listarId(id);
		
		List<Usuario> listaU=uService.buscarUsuarioID(id);
		
		if(objUsuario==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un roche");
			return "redirect:/usuario/listar";
		}
		else {
			model.addAttribute("denuncia",new Denuncia());
			model.addAttribute("usuarioN",listaU);
			return "DenunciarJugador";
		}		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Denuncia objdenuncia,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			model.addAttribute("mensaje","Torneo ya solicitado");
			return "redirect:/torneo/irTorneos";
		}
		else {
			         objdenuncia.setUsuario(objdenuncia.getUsuario());
					 boolean flag = dService.insertar(objdenuncia);	    
						
					if (flag) {				
						objdenuncia.getUsuario().setFUsuario("Inhabilitado");
						return "redirect:/torneo/irTorneos";
					}
					else {
						model.addAttribute("mensaje", "Ocurrio un roche");
						return "redirect:/torneo/irTorneos";
					} 

		}
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaDenuncias", dService.listar());
		return "listDenuncias";
	}
	
	
	
	
}
