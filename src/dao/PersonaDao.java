package dao;

import java.util.ArrayList;
import java.util.List;
import entidad.Persona;

public interface PersonaDao {
	public boolean agregar(Persona persona);
	
	public boolean modificar(Persona persona, String nombre, String apellido);
	
	public ArrayList<Persona> listar();

	public boolean delete(Persona persona);

	public List<Persona> obtenerPersonas();
}
