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
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbname = "bdpersonas";
	
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

	public boolean delete(Persona persona) {
	    String query = "DELETE FROM personas WHERE Dni = ?";
	    boolean exito = false;

	    try (Connection cn = DriverManager.getConnection(host + dbname, user, pass);
	         PreparedStatement pst = (PreparedStatement) cn.prepareStatement(query)) {
	         
	        pst.setString(1, persona.getDni());
	        int filas = pst.executeUpdate();
	        exito = (filas > 0);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return exito;
	}


	   @Override
	   public List<Persona> obtenerPersonas() {
	       List<Persona> personas = new ArrayList<>();
	       String query = "SELECT Dni, Nombre, Apellido FROM personas";  // Aseg�rate de que esta tabla existe
	       Connection cn = null;

	       try {
	           cn = DriverManager.getConnection(host + dbname, user, pass);
	           Statement st = (Statement) cn.createStatement();
	           ResultSet rs = st.executeQuery(query);

	           while (rs.next()) {
	               Persona persona = new Persona();
	               persona.setDni(rs.getString("Dni"));
	               persona.setNombre(rs.getString("Nombre"));
	               persona.setApellido(rs.getString("Apellido"));
	               personas.add(persona);
	           }

	           System.out.println("Personas cargadas: " + personas.size()); // Verifica cu�ntas personas se cargaron
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           try {
	               if (cn != null) cn.close();
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	       }
	       return personas;
	   }


	
	
	

}
