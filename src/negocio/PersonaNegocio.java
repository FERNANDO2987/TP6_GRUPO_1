package negocio;

import java.util.ArrayList;

import entidad.Persona;

public interface PersonaNegocio {
	
	public ArrayList<Persona> listar();
    public boolean eliminarPersona(String dni);
    
}
