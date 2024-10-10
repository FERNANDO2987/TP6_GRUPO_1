package precentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import precentacion.vista.PanelAgregar;
import precentacion.vista.PanelEliminar;
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
		this.ventanaPrincipal.getMntmAgregar().addActionListener(this);
		this.ventanaPrincipal.getMntmEliminar().addActionListener(this);
	}
	
	@SuppressWarnings("deprecation")
	public void inicializar()
	{
		this.ventanaPrincipal.show();
	}
	private void menuAgregar(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		PanelAgregar panel = new PanelAgregar();
		ventanaPrincipal.getContentPane().add(panel);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	private void menuEliminar(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		PanelEliminar panel = new PanelEliminar();
		ventanaPrincipal.getContentPane().add(panel);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == ventanaPrincipal.getMntmAgregar()) {
		        menuAgregar(e);
		
		 }else if (e.getSource() == ventanaPrincipal.getMntmEliminar()) {
			 menuEliminar(e);
	        }
	}
	
}
