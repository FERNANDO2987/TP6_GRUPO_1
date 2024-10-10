package negocioImpl;

import java.util.ArrayList;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	PersonaDao pdao = new PersonaDaoImpl();

	@Override
	public ArrayList<Persona> listar() {
		return pdao.listar();
	}
}
