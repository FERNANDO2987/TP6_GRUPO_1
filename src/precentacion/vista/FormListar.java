package precentacion.vista;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;

public class FormListar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel modelPersonas;
    private String[] nombreColumnas = { "Nombre", "Apellido", "DNI" };
    private PersonaDaoImpl personaDAO = new PersonaDaoImpl();

    public FormListar() {
    	setTitle("Listar personas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        modelPersonas = new DefaultTableModel(null, nombreColumnas);
        contentPane.setLayout(null);
        table = new JTable(modelPersonas);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 52, 326, 153);
        contentPane.add(scrollPane);

        llenarTabla();
    }


    public void llenarTabla() {
        List<Persona> personasEnTabla = personaDAO.obtenerPersonas(); 
        modelPersonas.setRowCount(0); 
        for (Persona p : personasEnTabla) {
            String nombre = p.getNombre();
            String apellido = p.getApellido();
            String dni = p.getDni();
            Object[] fila = { nombre, apellido, dni };
            modelPersonas.addRow(fila);
        }
    }

    public static void main(String[] args) {
        FormListar frame = new FormListar();
        frame.setVisible(true);
    }
}
