package pe.edu.upc.spring.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.Torneo;
import pe.edu.upc.spring.model.InscripcionTorneo;

import java.text.ParseException;
import java.util.Date;
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
	
	Date fecha= new Date();

	String ins="Platino";

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
			model.addAttribute("mensaje","Usuario ya inscrito");
			return "redirect:/InscripcionTorneo/irRegistrar";
		}
		else {
			    List<InscripcionTorneo> IT;			    
			    objIns_Torneo.setUsuario(objIns_Torneo.getUsuario());
			    objIns_Torneo.setTorneo(objIns_Torneo.getTorneo()); 
			    objIns_Torneo.setTorneo(objIns_Torneo.getTorneo());
			    IT=itService.buscarTorneoPorUsuarioTorneo(objIns_Torneo.getUsuario(),objIns_Torneo.getTorneo());
				if(IT.isEmpty()  && objIns_Torneo.getTorneo().getVacantes()>0 && objIns_Torneo.getUsuario().getSaldUsuario()>objIns_Torneo.getTorneo().getCostoTorneo()){
				         
				               objIns_Torneo.getTorneo().setVacantes(objIns_Torneo.getTorneo().getVacantes() -1);
							   objIns_Torneo.getTorneo().getVideojuego().setNumcompetidores(objIns_Torneo.getTorneo().getVideojuego().getNumcompetidores()+1);
							   objIns_Torneo.getUsuario().setSaldUsuario(objIns_Torneo.getUsuario().getSaldUsuario() - objIns_Torneo.getTorneo().getCostoTorneo() );
							   objIns_Torneo.getUsuario().setNumInscrip(objIns_Torneo.getUsuario().getNumInscrip() + 1);
							   
							   if( objIns_Torneo.getUsuario().getNumInscrip()==3) {
								   objIns_Torneo.getUsuario().setInsigUsuario(ins);
							   }
							   
							   boolean flag = itService.insertar(objIns_Torneo);
								    if(flag)
									{
								    	model.addAttribute("listaTorneo",tService.listar());
									    return "redirect:/torneo/listar";
									}
								    else {
								    	model.addAttribute("mensaje","Ocurrio un problema");
										return "redirect:/InscripcionTorneo/irRegistrar";
								    }						  
				           
			            	
				}
				else {
					model.addAttribute("mensaje","Ocurrio un problema");
					return "redirect:/InscripcionTorneo/irRegistrar";
				}
			
		}
				
	}
	
		
	
	
	
}
		
	
		
	
	
	

