package com.example.demo2.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.demo.services.PersonajeServices;
import com.example.demo2.models.Personaje;
import com.example.demo2.models.Response;
import com.example.demo2.services.IPersonajeServices;

@Controller
@RequestMapping("/app")
public class HomeController {
	
	@Value("${title.generic}")
	private String titlePage;
	
	@Value("${mensaje}")
	private String mensaje;
	
	@Autowired
	@Qualifier("servicio1")
	private IPersonajeServices InterfacePersonaje1;
	
	@Autowired
	@Qualifier("servicio2")
	private IPersonajeServices InterfacePersonaje2;
	
	//@RequestMapping("/home")
	@GetMapping({"/home","/Home", "/" })
	public String Home( Model model) {

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Seccion J98");
		model.addAttribute("mensaje", mensaje);
		/*
		Personaje personaje = new Personaje();
		
		if(InterfacePersonaje1.crearPersonaje(personaje).getEstado()) {
			model.addAttribute("listita", InterfacePersonaje1.crearPersonaje(personaje).getData());
			
		}*/
		/*para que muestre todos los datos*//*
		List<Personaje> listasUnidas = new ArrayList<>();
		listasUnidas.addAll(InterfacePersonaje1.crearPersonaje().getData());
		listasUnidas.addAll(InterfacePersonaje2.crearPersonaje().getData());
		model.addAttribute("listita",listasUnidas);*/
		/**/
		/*
		model.addAttribute("Estado", InterfacePersonaje1.crearPersonaje(personaje).getMensaje());
		
		String respuesta = InterfacePersonaje1.demoMetodo(personaje);
		
		model.addAttribute("respuesta", respuesta);*/
		
		return "Home";
	}
	
	@GetMapping({"/listar" })
	public String ListarPersonajes(Model model) {
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo","Seccion J98");
		model.addAttribute("mensaje",mensaje);
		
		Response<Personaje> rspta = InterfacePersonaje1.listarPersonaje();
		
		model.addAttribute("listita", rspta.getData());
		
		return "Lista";
	}
	
	@GetMapping("/crear")
	public String Formulario (Model model) {
		Personaje personaje = new Personaje();
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo","Seccion J98 - Crear Personaje");
		model.addAttribute("personaje", personaje);
		
		return "Formulario";
	}
	
	@PostMapping("/form")
	public String crearPersonaje(@Valid Personaje Luffy, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			/*Map<String, String> erroresPersonaje = new HashMap<>();
			result.getFieldErrors().forEach(PersonajeErrores ->{
				erroresPersonaje.put(PersonajeErrores.getField(), PersonajeErrores.getDefaultMessage());
				
			});
			model.addAttribute("TituloPagina", titlePage);
			model.addAttribute("titulo","Seccion J98 - Personaje Creado");
			model.addAttribute("error", erroresPersonaje);
			model.addAttribute("personaje", Luffy);*/
			
			return "Formulario";
		}
		
		//Logica de creacion de personaje
		Response<Personaje> rspta= InterfacePersonaje1.crearPersonaje(Luffy);
		
		if(rspta.getEstado()) {
			return "redirect:Lista";
		}else {
			model.addAttribute("mensaje", rspta.getMensaje());
			return "redirect:Error";
		}
		
	}
	

}
