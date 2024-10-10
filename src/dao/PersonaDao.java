package dao;

import java.util.ArrayList;
import java.util.List;
import entidad.Persona;

public interface PersonaDao {
	public boolean agregar(Persona persona);
	
	public ArrayList<Persona> listar();

	public boolean delete(Persona persona);

	public List<Persona> obtenerPersonas();
}
