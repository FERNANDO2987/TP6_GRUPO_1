package precentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JLabel;


public class FormModificar extends JFrame {
	static final long serialVersionUID = 1L;
	private JTextField txtNombreSelect;
	private JTextField txtApellidoSelect;
	private JTextField txtDniSelect;
	private JList list;

	public FormModificar() {
		setTitle("Programa");  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setSize(470, 300); 
        getContentPane().setLayout(null);
        
        txtNombreSelect = new JTextField();
        txtNombreSelect.setBounds(30, 220, 86, 20);
		getContentPane().add(txtNombreSelect);
		txtNombreSelect.setColumns(10);

		txtApellidoSelect = new JTextField();
		txtApellidoSelect.setColumns(10);
		txtApellidoSelect.setBounds(130, 220, 86, 20);
		getContentPane().add(txtApellidoSelect);
		
		txtDniSelect = new JTextField();
		txtDniSelect.setColumns(10);
		txtDniSelect.setBounds(230, 220, 86, 20);
		getContentPane().add(txtDniSelect);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(330, 220, 89, 23);
		getContentPane().add(btnModificar);
		
		list = new JList();
		list.setBounds(30, 43, 389, 170);
		getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("Seleccione la persona que desea modificar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 23, 389, 14);
		getContentPane().add(lblNewLabel);

	}
}
