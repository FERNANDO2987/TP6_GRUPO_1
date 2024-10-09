package precentacion.vista;

import javax.swing.*;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class FormAgregar extends JFrame {  
    private static final long serialVersionUID = 1L;  
    private JTextField nombreField;  
    private JTextField apellidoField;  
    private JTextField dniField;  
    private JButton aceptarButton;  

    public FormAgregar() {  
        setTitle("Persona");  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setSize(400, 300);  
        setLocationRelativeTo(null);  
        setLayout(new GridBagLayout());  
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nombreLabel = new JLabel("Nombre");  
        nombreField = new JTextField(10);  

        JLabel apellidoLabel = new JLabel("Apellido");  
        apellidoField = new JTextField(10);  

        JLabel dniLabel = new JLabel("Dni");  
        dniField = new JTextField(10);  

        aceptarButton = new JButton("Aceptar");  
        aceptarButton.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                String nombre = nombreField.getText().trim();  
                String apellido = apellidoField.getText().trim();  
                String dni = dniField.getText().trim();  

                // Validar si todos los campos están completos
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
                    JOptionPane.showMessageDialog(FormAgregar.this,   
                        "Es necesario completar todos los campos",  
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Crear una instancia de Persona
                    Persona persona = new Persona();
                    persona.setNombre(nombre);
                    persona.setApellido(apellido);
                    persona.setDni(dni);

                    // Instanciar PersonaDaoImpl para agregar la persona
                    PersonaDao personaDao = new PersonaDaoImpl();
                    boolean exito = personaDao.agregar(persona);
                    
                    if (exito) {
                        JOptionPane.showMessageDialog(FormAgregar.this,   
                            "Persona agregada exitosamente",  
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        // Limpiar campos después de enviar  
                        nombreField.setText("");  
                        apellidoField.setText("");  
                        dniField.setText("");  
                    } else {
                        JOptionPane.showMessageDialog(FormAgregar.this,   
                            "El DNI ya existe en la base de datos",  
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }  
        }); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nombreLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nombreField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(apellidoLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(apellidoField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(dniLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(dniField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(aceptarButton, gbc);
    }  

  
   }  

