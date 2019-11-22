package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.SolicitudTorneo;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import pe.edu.upc.spring.model.SolicitudTorneo;
import pe.edu.upc.spring.service.ISolicitudTorneoService;
import pe.edu.upc.spring.service.ITorneoService;
import pe.edu.upc.spring.service.IUsuarioService;

@Controller
@RequestMapping("/SolicitudTorneo")
public class SolicitudTorneoController {

	@Autowired
	private ISolicitudTorneoService stService;
	@Autowired
	private ITorneoService tService;
	@Autowired
	private IUsuarioService uService;
	
	String s= "Pendiente";
		String a ="Aprobado";
		String r ="Rechazado";
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("Solicitud", new SolicitudTorneo());		
		model.addAttribute("torneos",tService.listar());
		model.addAttribute("usuarios",uService.listar());
		return "SolicitarTorneo";
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid SolicitudTorneo objIns_Torneo,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			model.addAttribute("mensaje","Torneo ya solicitado");
			return "redirect:/SolicitudTorneo/irRegistrar";
		}
		else {
			List<SolicitudTorneo> ST;
			objIns_Torneo.setTorneo(objIns_Torneo.getTorneo());
			ST=stService.buscarTorneoPorTorneo(objIns_Torneo.getTorneo());
			if(ST.isEmpty()){
					 boolean flag = stService.insertar(objIns_Torneo);			    
						
					if (flag) {
						return "redirect:/usuario/irNANGO";
					}
					else {
						model.addAttribute("mensaje", "Ocurrio un roche");
						return "redirect:/SolicitudTorneo/irRegistrar";
					}
			}
			else {
				model.addAttribute("mensaje","Torneo ya solicitado");
				return "redirect:/SolicitudTorneo/irRegistrar";
			}
				   

		}
				
	}
	
	
	@RequestMapping("/registrar2")
	public String registrar2(@ModelAttribute @Valid SolicitudTorneo objIns_Torneo,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			model.addAttribute("mensaje","Torneo ya solicitado");
			return "redirect:/SolicitudTorneo/irRegistrar";
		}
		else {
					objIns_Torneo.setEstadSolicitud(objIns_Torneo.getEstadSolicitud());
					objIns_Torneo.getTorneo().setEstadCreaTorneo(objIns_Torneo.getEstadSolicitud());
										
					 boolean flag = stService.insertar(objIns_Torneo);			    
						
					if (flag) {
						return "redirect:/SolicitudTorneo/listar";
					}
					else {
						model.addAttribute("mensaje", "Ocurrio un roche");
						return "redirect:/SolicitudTorneo/irRegistrar";
					}
		}
			  
	}
				
	
	
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute @Valid SolicitudTorneo objIns_Torneo,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			model.addAttribute("mensaje","Ocurrio un problema");
			return "redirect:/SolicitudTorneo/irRegistrar";
		}
		else {
			
			 boolean flag = stService.modificar(objIns_Torneo);			    
				
			if (flag) {
				model.addAttribute("listaTorneo",tService.listar());
				return "redirect:/torneo/Torneos";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/SolicitudTorneo/listar";
			}
				   

		}
				
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object>model,@RequestParam(value="id")Integer id) {
			if(id!=null && id>0) {
				stService.eliminar(id);
				model.put("listaSoliTorneo", stService.listar());
			}

		return "redirect:/SolicitudTorneo/listar";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaSoliTorneo", stService.listar());
		return "listSolicitudesTorneo";
	}
	
	@RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<SolicitudTorneo> objSoliTorneo =stService.listarId(id);
		if(objSoliTorneo==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un problema");
			return "redirect:/SolicitudTorneo/listar";
		}
		else {
			
			model.addAttribute("SolicitudTorne",objSoliTorneo);
			model.addAttribute("torneos",tService.listar());
			model.addAttribute("usuarioN",uService.listar());
			return "modificarSolicitarTorneo";
		}		
	}
	
	@RequestMapping("/ver/{id}")
    public String ver(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<SolicitudTorneo> objSoliTorneo =stService.listarId(id);
		if(objSoliTorneo==null) {
			objRedir.addFlashAttribute("mensaje","ocurrio un problema");
			return "redirect:/SolicitudTorneo/listar";
		}
		else {
			
			model.addAttribute("SolicitudTorne",objSoliTorneo);
			model.addAttribute("torneos",tService.listar());
			model.addAttribute("usuarioN",uService.listar());
			return "verSolicitarTorneo";
		}		
	}
	
	
}


