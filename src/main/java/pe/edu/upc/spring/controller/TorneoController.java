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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.service.ITorneoService;
import pe.edu.upc.spring.service.IInscripcionTorneoService;
import pe.edu.upc.spring.service.IServidorService;
import pe.edu.upc.spring.service.IVideojuegoServidor;

@Controller
@RequestMapping("/torneo")


public class TorneoController {

	@Autowired
	private ITorneoService tService;
	@Autowired
	private IServidorService sService;
	@Autowired
	private IVideojuegoServidor vService;
	@Autowired
	private IInscripcionTorneoService itService;

	String s="Aprobado";
	String s2="Finalizado";
	
	@RequestMapping("/irTorneos")
	public String irBuscarTorneo(Model model) {
		model.addAttribute("torneo", new Torneo());
		model.addAttribute("listaTorneo",tService.buscarTorneoPorAprobado(s,s2));
		model.addAttribute("servidores",sService.listar());
		model.addAttribute("videojuegos",vService.listar());
		return "Torneos";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaTorneo", tService.listar());
		return "listTorneos";
	}
	


	@RequestMapping("/Torneos")
	public String buscar(Map<String, Object> model, @ModelAttribute Torneo torneo) throws ParseException {
		List<Torneo> listaTorneo;
	    torneo.setVideojuego(torneo.getVideojuego());
	    torneo.setModoTorneo(torneo.getModoTorneo());
	    torneo.setServidor(torneo.getServidor());
	    torneo.setEstadTranscuTorneo(torneo.getEstadTranscuTorneo());
		listaTorneo=tService.buscarTorneoFiltroTotal(torneo.getVideojuego(), torneo.getModoTorneo(),torneo.getServidor(),torneo.getEstadTranscuTorneo());
		if (listaTorneo.isEmpty()) {
			model.put("mensaje", "No se encontro");	
		}
		model.put("videojuegos",vService.listar());
		model.put("servidores",sService.listar());
		model.put("listaTorneo", listaTorneo);

		return "Torneos";		
	}
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("torneo", new Torneo());		
		model.addAttribute("servidores",sService.listar());
		model.addAttribute("videojuegos",vService.listar());
		return "torneo";
	}
	
	@RequestMapping("/irRegistrar2")
	public String irRegistrar2(Model model) {
		model.addAttribute("torneo", new Torneo());		
		model.addAttribute("servidores",sService.listar());
		model.addAttribute("videojuegos",vService.listar());
		return "crearTorneoUsuario";
	}
	
	@RequestMapping("/registrar2")
	public String registrar2(@ModelAttribute @Valid Torneo objTorneo,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/torneo/irRegistrar2";
		}
		else {
					
			boolean flag = tService.insertar(objTorneo);
			if(flag) {
				model.addAttribute("listaTorneo",tService.listar());
				return "redirect:/torneo/irTorneos";}
			else 
			{
				
				return "torneo";
			}
		}
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Torneo objTorneo,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/torneo/irRegistrar";
		}
		else {
					
			boolean flag = tService.insertar(objTorneo);
			if(flag) {
				model.addAttribute("listaTorneo",tService.listar());
				return "listTorneos";}
			else 
			{
				
				return "torneo";
			}
		}
		
	}
	
	@RequestMapping("/actualizar")
	public String actualizar (@ModelAttribute @Valid Torneo objTorneo,
			BindingResult binRes, Model model, RedirectAttributes objRedir)
	throws ParseException
	{
		if(binRes.hasErrors()) {
			return "torneo";
		}
		else {
		
			boolean flag= tService.modificar(objTorneo);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","se actualizo correctamente");
				return "listTorneos";
			}
			else {
				
				objRedir.addFlashAttribute("mensaje","ocurrio un roche al actualizar xd");
				return "torneo";
			}
				
		}
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String,Object>model, @ModelAttribute Torneo torneo) {
		tService.listarId(torneo.getIdTorneo());
		
		return "listUsuario";
	}

	
	@RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Torneo> objTorneo =tService.listarId(id);
		if(objTorneo==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un roche, naciste feo");
			return "redirect:/torneo/listar";
		}
		else {
			
			model.addAttribute("torneo",objTorneo);
			model.addAttribute("servidores",sService.listar());
			model.addAttribute("videojuegos",vService.listar());
			return "torneo";
		}		
	}
	
	@RequestMapping("/verTorneo/{id}")
    public String verTorneo(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Torneo> objTorneo =tService.listarId(id);
        Torneo t= tService.escogeTorneo(id);
     
		if(objTorneo==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un roche");
			return "redirect:/torneo/irTorneos";
		}
		else {
			model.addAttribute("torneo",objTorneo);
			model.addAttribute("servidores",sService.listar());
			model.addAttribute("videojuegos",vService.listar());
			model.addAttribute("Inscritos",itService.buscarTorneoPorTorneo(t));
			return "torneoVistaUsuario";
		}		
	}
	
	@RequestMapping("/verTorneo2/{id}")
    public String verTorneo2(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Torneo> objTorneo =tService.listarId(id);
  
		if(objTorneo==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un roche");
			return "redirect:/torneo/irTorneos";
		}
		else {
			model.addAttribute("torneo",objTorneo);
			model.addAttribute("servidores",sService.listar());
			model.addAttribute("videojuegos",vService.listar());
			return "torneoVistaMisTorneos";
		}		
	}	
	
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object>model,@RequestParam(value="id")Integer id) {
		if(id!=null && id>0) {
				tService.eliminar(id);
				model.put("listaTorneos",tService.listar());
				
			}
		return "redirect:/torneo/listar";

	}
	
}
