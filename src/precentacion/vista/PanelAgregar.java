package precentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;

	
	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(101, 38, 88, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(101, 66, 88, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(101, 97, 88, 14);
		add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 35, 107, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(199, 63, 107, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(199, 94, 107, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(101, 125, 98, 23);
		add(btnAceptar);

	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}


	public JButton getBtnAceptar() {
		return btnAceptar;
	}


	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	
	
}
