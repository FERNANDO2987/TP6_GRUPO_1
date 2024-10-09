package precentacion.vista;

import javax.swing.*;
import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import java.util.List;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class FormEliminar extends JFrame {
    private static final long serialVersionUID = 1L;

    private JList<Persona> personaList; // JList para mostrar las personas
    private DefaultListModel<Persona> listModel; // Modelo de lista para agregar y eliminar
    private JButton eliminarButton; // Botón para eliminar la persona seleccionada
    private PersonaDao personaDao; // Interfaz DAO

    public FormEliminar() {
        personaDao = new PersonaDaoImpl(); // Inicializar el DAO
        listModel = new DefaultListModel<>(); // Inicializar el modelo de la lista
        personaList = new JList<>(listModel); // Crear la lista con el modelo

        cargarPersonas(); // Cargar personas desde la base de datos

        // Resto de la configuración del JFrame
        setTitle("Eliminar Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Configuración del botón eliminar
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona selectedPersona = personaList.getSelectedValue();
                if (selectedPersona != null) {
                    boolean exito = personaDao.delete(selectedPersona);
                    if (exito) {
                        listModel.removeElement(selectedPersona); // Quitar de la lista
                        JOptionPane.showMessageDialog(FormEliminar.this,
                                "Persona eliminada exitosamente",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(FormEliminar.this,
                                "Error al eliminar la persona",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(FormEliminar.this,
                            "Seleccione una persona para eliminar",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Configuración del layout
        setLayout(new BorderLayout());
        add(new JScrollPane(personaList), BorderLayout.CENTER); // Agregar lista con scroll
        add(eliminarButton, BorderLayout.SOUTH); // Agregar botón al sur

        setVisible(true); // Hacer visible el JFrame
    }

    private void cargarPersonas() {
        listModel.clear(); // Limpia el modelo de la lista antes de cargar
        List<Persona> personas = (List<Persona>) personaDao.obtenerPersonas();
        for (Persona persona : personas) {
            listModel.addElement(persona);
        }
        System.out.println("Total de personas cargadas: " + listModel.getSize());
    }

}
