package precentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.List;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormModificar extends JFrame {
	static final long serialVersionUID = 1L;
	
	private JList<Persona> personaList; 
	private DefaultListModel<Persona> listModel; 
	private JTextField txtNombreSelect;
	private JTextField txtApellidoSelect;
	private JTextField txtDniSelect;
	private JButton btnModificar;
	private JLabel lblTexto;
	private PersonaDao personaDao; 

	public FormModificar() {
		
		personaDao = new PersonaDaoImpl(); 
        listModel = new DefaultListModel<>(); 
        personaList = new JList<>(listModel); 
        
        cargarPersonas(); 
		
		setTitle("Modificar persona");  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setSize(490, 300); 
        setLocationRelativeTo(null);
        
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
		txtDniSelect.setEditable(false);
		getContentPane().add(txtDniSelect);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(330, 220, 100, 23);
		getContentPane().add(btnModificar, BorderLayout.SOUTH);
			
		lblTexto = new JLabel("Seleccione la persona que desea modificar");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTexto.setBounds(30, 23, 400, 14);
		getContentPane().add(lblTexto);

		personaList.setBounds(30, 43, 400, 170);
		getContentPane().add(personaList);
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre = txtNombreSelect.getText();  
                String apellido = txtApellidoSelect.getText();  
                
				Persona selectedPersona = personaList.getSelectedValue();	
				
                if (txtNombreSelect.getText().isEmpty() || txtNombreSelect.getText().isEmpty() || txtDniSelect.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(FormModificar.this,   
                        "Es necesario completar todos los campos",  
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (selectedPersona != null) {
              
                	boolean exito = personaDao.modificar(selectedPersona, nombre, apellido);
                    if (exito) {
                    	cargarPersonas();
                        JOptionPane.showMessageDialog(FormModificar.this,
                        		"Persona modificada exitosamente",
                        		"Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                            JOptionPane.showMessageDialog(FormModificar.this, 
                            	"Error al modificar la persona",
                            	"Error", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                else {
                	JOptionPane.showMessageDialog(FormModificar.this,    
                			"Seleccione una persona para modificar",          
                			"Advertencia", JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		
		personaList.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent arg0) {
        		Persona selectedPersona = personaList.getSelectedValue();
        		if (selectedPersona != null) {
                    txtNombreSelect.setText(selectedPersona.getNombre());
                    txtApellidoSelect.setText(selectedPersona.getApellido());
                    txtDniSelect.setText(selectedPersona.getDni());
                } else {
                    JOptionPane.showMessageDialog(FormModificar.this,
                            "Seleccione una persona para modificar",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
        	}
        });
		
		// Configuración del layout
        getContentPane().setLayout(new BorderLayout());
	}
	
	private void cargarPersonas() {
        listModel.clear();
        List<Persona> personas = (List<Persona>) personaDao.obtenerPersonas();
        for (Persona persona : personas) {
            listModel.addElement(persona);
        }
        System.out.println("Total de personas cargadas: " + listModel.getSize());
    }

}
