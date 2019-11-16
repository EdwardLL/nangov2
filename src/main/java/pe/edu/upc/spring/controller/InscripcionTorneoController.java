package pe.edu.upc.spring.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.Torneo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import pe.edu.upc.spring.model.InscripcionTorneo;
import pe.edu.upc.spring.service.IInscripcionTorneoService;
import pe.edu.upc.spring.service.ITorneoService;
import pe.edu.upc.spring.service.IUsuarioService;

@Controller
@RequestMapping("/InscripcionTorneo")
public class InscripcionTorneoController {

	@Autowired
	private IInscripcionTorneoService itService;
	@Autowired
	private ITorneoService tService;
	@Autowired
	private IUsuarioService uService;
	

	@RequestMapping("/irBuscarTorneo")
	public String irBuscarTorneo(Model model) {
		model.addAttribute("torneo", new Torneo());
		model.addAttribute("listaTorneo",tService.listar());
		return "buscarTorneo";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaTorneo", tService.listar());

		return "listTorneos";
	}
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("InscripcionTorneo", new InscripcionTorneo());		
		model.addAttribute("torneos",tService.listar());
		model.addAttribute("usuarios",uService.listar());
		return "InscripcionATorneo";
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid InscripcionTorneo objIns_Torneo,
			BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/InscripcionTorneo/irRegistrar";
		}
		else {
			if(objIns_Torneo.getTorneo().getVacantes()>0)
			{	
				objIns_Torneo.getTorneo().setVacantes(objIns_Torneo.getTorneo().getVacantes()-1);
				    boolean flag = itService.insertar(objIns_Torneo);
					model.addAttribute("listaTorneo",tService.listar());
					return "redirect:/torneo/listar";
			}
			else {
				return "redirect:/InscripcionTorneo/irRegistrar";	
			}
			
		}
				
	}
	
	
	
		
}
		
	
		
	
	
	
