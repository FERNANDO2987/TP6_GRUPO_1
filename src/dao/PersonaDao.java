package dao;

import java.util.ArrayList;

import entidad.Persona;

public interface PersonaDao {
	public boolean agregar(Persona persona);
	public ArrayList<Persona> listar();
}
