package com.example.demo2.services;

import com.example.demo2.models.Personaje;
import com.example.demo2.models.Response;

public interface IPersonajeServices {
	public Response<Personaje> crearPersonaje( Personaje p);
	public String editarPersonaje();

	public Response<Personaje> listarPersonaje();
 
}
