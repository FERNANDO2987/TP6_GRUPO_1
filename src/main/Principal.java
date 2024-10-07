package main;

import negocio.PersonaNegocio;
import precentacion.controlador.*;
import precentacion.vista.*;


public class Principal {

	public static void main(String[] args) {
		
		// 
		VentanaPrincipal vista = new VentanaPrincipal();
		
		PersonaNegocio negocio = new PersonaNegocio();
		
		Controlador controlador = new Controlador(vista, negocio);
		
		controlador.inicializar();
		
	}

}
