package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

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

	@Override
	public ArrayList<Persona> listar() {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection cn = null;
		
		try 
		{
			cn = DriverManager.getConnection(host+dbname,user,pass);
			Statement st = cn.createStatement();
			String query = "Select * From Personas";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				personas.add(getPersona(rs));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("dniPersona");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}

}
