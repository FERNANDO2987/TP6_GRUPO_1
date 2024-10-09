package precentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.PersonaNegocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelEliminar extends JPanel {
    private static final long serialVersionUID = 1L;
	private PersonaNegocio pNeg;
    private JTextField txtDni;
    private JButton btnEliminar;

    public PanelEliminar() {
        setLayout(null);

        JLabel lblDni = new JLabel("Dni");
        lblDni.setBounds(101, 38, 88, 14);
        add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(199, 35, 107, 20);
        add(txtDni);
        txtDni.setColumns(10);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(101, 125, 98, 23);
        add(btnEliminar);

        // Agregar el ActionListener al bot�n
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPersona(); // Llamar al m�todo eliminarPersona al hacer clic en el bot�n
            }
        });
    }

    private void eliminarPersona() {
        String dni = txtDni.getText(); // Obtener el DNI del campo de texto

        if (!dni.isEmpty()) { // Verificar que el campo no est� vac�o
            boolean exito = pNeg.eliminarPersona(dni); // Llama al m�todo de negocio para eliminar la persona
            if (exito) {
                txtDni.setText(""); // Limpiar el campo despu�s de eliminar
                JOptionPane.showMessageDialog(this, "Persona eliminada con �xito.", "�xito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontr� una persona con ese DNI.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un DNI.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
