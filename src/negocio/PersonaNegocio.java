package negocio;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;

public class PersonaNegocio {
    private PersonaDao personaDao;

    public PersonaNegocio() {
        personaDao = new PersonaDaoImpl(); // Aseg�rate de que esto sea correcto
    }

    public boolean eliminarPersona(String dni) {
        Persona persona = new Persona();
        persona.setDni(dni);
        return personaDao.delete(persona); // Aqu� usas la instancia, no est�tica
    }
}
