package precentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import precentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener
{
	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;

	
	public Controlador(VentanaPrincipal ventanaPrincipal, PersonaNegocio pNeg) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
		this.pNeg = pNeg;
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.show();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
