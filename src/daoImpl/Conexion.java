package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	
	private Conexion()
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/bdPersonas?useSSL=false", "root", "root");

			this.connection.setAutoCommit(false);
		}
		catch(SQLException e)
		{
			System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
			throw new RuntimeException("Error al conectar con la base de datos", e);
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		if (this.connection != null) {
			try 
			{
				this.connection.close();
			}
			catch (SQLException e) 
			{
				System.err.println("Error al cerrar la conexión con la base de datos: " + e.getMessage());
			}
			finally
			{
				instancia = null;
			}
		}
	}
}
