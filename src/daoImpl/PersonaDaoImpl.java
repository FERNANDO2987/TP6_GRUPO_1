package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbname = "bdregistro";
	
	@Override
	public boolean agregar(Persona persona) {
		String query = "Insert into personas(Dni, Nombre, Apellido) values ('"+persona.getDni()+"','"+persona.getNombre()+"','"+persona.getApellido()+"')";
		Connection cn = null;
		int filas = 0;
		try 
		{
			
			cn = DriverManager.getConnection(host+dbname,user,pass);
			java.sql.Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		 if (filas == 1)
			 return true;
		 else
			 return false;
	}

}
