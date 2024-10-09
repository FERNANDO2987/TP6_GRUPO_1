package dao;



import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	public boolean agregar(Persona persona);

	public boolean delete(Persona persona);

	public List<Persona> obtenerPersonas();
}
