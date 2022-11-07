
package com.example.demo2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo2.models.Personaje;
import com.example.demo2.models.Response;

@Component("servicio1")
@Primary
public class PersonajeServices implements IPersonajeServices  {
	
	public Response<Personaje> crearPersonaje(Personaje personajeRecibido) {
		
		Response<Personaje> response = new Response<>();
		
		boolean estadoCreacion = false;
		
		//Instanciando una lista del tipo List del tipo Personaje
		List<Personaje> listita = new ArrayList<>();
		
		
		//Instanciando un personaje1 del tipo Personaje
		Personaje personaje1 = new Personaje();
				
		//Agregando datos a los atributos del personaje 1
		personaje1.setNombres("Luffy");
		personaje1.setAlias("Luffy Alias");
		personaje1.setTipoFruta("Luffy Tipo Fruta");
		personaje1.setHabilidad("Luffy Habilidad");
		personaje1.setTripulacion("Luffy Tripulacion");
		personaje1.setRecompensa("123546789");
				
				
		//Instanciando un personaje2 del tipo Personaje
		Personaje personaje2 = new Personaje();
						
		//Agregando datos a los atributos del personaje 1
		personaje2.setNombres("Luffy 2");
		personaje2.setAlias("Luffy Alias 2");
		personaje2.setTipoFruta("Luffy Tipo Fruta 2");
		personaje2.setHabilidad("Luffy Habilidad 2");
		personaje2.setTripulacion("Luffy Tripulacion 2");
		personaje2.setRecompensa("123546789 2");
		
		
		//Instanciando un personaje2 del tipo Personaje
		Personaje personaje3 = new Personaje();
								
		//Agregando datos a los atributos del personaje 1
		personaje3.setNombres("Luffy 3");
		personaje3.setAlias("Luffy Alias 3");
		personaje3.setTipoFruta("Luffy Tipo Fruta 3");
		personaje3.setHabilidad("Luffy Habilidad 3");
		personaje3.setTripulacion("Luffy Tripulacion 3");
		personaje3.setRecompensa("123546789 3");
				
				
				
		//Agregando un personaje a la lista
		listita.add(personaje1);
		listita.add(personaje2);
		listita.add(personaje3);
		
		//Agregar validación por los alumnos del J98
		//listita.add(personajeRecibido);
		
		
		if(personajeRecibido.getNombres() != null &&
				personajeRecibido.getAlias() != null &&
				personajeRecibido.getRecompensa() != null) {
			listita.add(personajeRecibido);
		}
		
		//validacion de lista de personajes
		if(listita.size()>0) {
			estadoCreacion = true;
			response.setEstado(estadoCreacion);
			response.setMensaje("Creado correctamente");
			response.setData(listita);
		}else {
			response.setEstado(estadoCreacion);
			response.setMensaje("Se produjo un error al crear un personaje");
		}

		
		return response;
	}
    
	public String editarPersonaje() {
		
		return "Se ha editado un personaje";
	}
    
    
    @Override
    public Response<Personaje> listarPersonaje() {
    	
    	//Instanciando una lista del tipo List del tipo Personaje
    			List<Personaje> listita = new ArrayList<>();
    			Response<Personaje> response = new Response<>();
    			
    			//Instanciando un personaje1 del tipo Personaje
    			Personaje personaje1 = new Personaje();
    					
    			//Agregando datos a los atributos del personaje 1
    			personaje1.setNombres("Luffy v2");
    			personaje1.setAlias("Luffy Alias v2");
    			personaje1.setTipoFruta("Luffy Tipo Fruta v2");
    			personaje1.setHabilidad("Luffy Habilidad v2");
    			personaje1.setTripulacion("Luffy Tripulacion v2");
    			personaje1.setRecompensa("123546789 v2");
    					
    					
    			//Instanciando un personaje2 del tipo Personaje
    			Personaje personaje2 = new Personaje();
    							
    			//Agregando datos a los atributos del personaje 1
    			personaje2.setNombres("Luffy 2 v2");
    			personaje2.setAlias("Luffy Alias 2 v2");
    			personaje2.setTipoFruta("Luffy Tipo Fruta 2 v2");
    			personaje2.setHabilidad("Luffy Habilidad 2 v2");
    			personaje2.setTripulacion("Luffy Tripulacion 2 v2");
    			personaje2.setRecompensa("123546789 2 v2");
    			
    			
    			//Instanciando un personaje2 del tipo Personaje
    			Personaje personaje3 = new Personaje();
    									
    			//Agregando datos a los atributos del personaje 1
    			personaje3.setNombres("Luffy 3 v2");
    			personaje3.setAlias("Luffy Alias 3 v2");
    			personaje3.setTipoFruta("Luffy Tipo Fruta 3 v2");
    			personaje3.setHabilidad("Luffy Habilidad 3 v2");
    			personaje3.setTripulacion("Luffy Tripulacion 3 v2");
    			personaje3.setRecompensa("123546789 3 v2");
    					
    					
    					
    			//Agregando un personaje a la lista
    			listita.add(personaje1);
    			listita.add(personaje2);
    			listita.add(personaje3);
    			
    			response.setEstado(true);
    			response.setMensaje("Creado correctamente");
    			response.setData(listita);
    			
    			return response;
  
    }

}
