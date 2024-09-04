import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FrmContactos extends JFrame {

    private JToolBar jtbContactos;
    private JTable tblContactos;


    Lista lContactos = new Lista();

    public FrmContactos() {
        setSize(600, 300);
        setTitle("Contactos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jtbContactos = new JToolBar();
        tblContactos = new JTable();

        JButton btnAgregar = new JButton();
        JButton btnEliminar = new JButton();
        JButton btnGuardar = new JButton();
        JButton btnOrdenar = new JButton();

        btnAgregar.setIcon(new ImageIcon(getClass().getResource("/Img/Agregar.png")));
        btnAgregar.setToolTipText("Agregar");
        btnEliminar.setIcon(new ImageIcon(getClass().getResource("/Img/Eliminar.png")));
        btnEliminar.setToolTipText("Eliminar");
        btnGuardar.setIcon(new ImageIcon(getClass().getResource("/Img/Guardar.png")));
        btnGuardar.setToolTipText("Guardar");
        btnOrdenar.setIcon(new ImageIcon(getClass().getResource("/Img/Ordenar.png")));
        btnOrdenar.setToolTipText("Ordenar");

        jtbContactos.add(btnAgregar);
        jtbContactos.add(btnEliminar);
        jtbContactos.add(btnGuardar);
        jtbContactos.add(btnOrdenar);

        JScrollPane jspContactos = new JScrollPane(tblContactos);

        getContentPane().add(jtbContactos, BorderLayout.NORTH);
        getContentPane().add(jspContactos, BorderLayout.CENTER);

        String nombreArchivo = System.getProperty("user.dir") + "/Proyectos/Contactos/src/Data/Datos.txt";

        lContactos.desdeArchivo(nombreArchivo);
        lContactos.mostrar(tblContactos);

        btnAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnAgregar_Click(e);
            }
            
        });

        btnEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminar_Click(e);
            }
            
        });

        btnGuardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardar_Click(e);
            }
            
        });

        btnOrdenar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnOrdenar_Click(e);
            }
            
        });
    }

    private void btnAgregar_Click(ActionEvent e) {
        lContactos.agregar(new Nodo());
        lContactos.mostrar(tblContactos);
    }

    private void btnEliminar_Click(ActionEvent e) {
        if (tblContactos.getSelectedRow() >= 0) {
            lContactos.eliminar(lContactos.obtener(tblContactos.getSelectedRow()));
            lContactos.mostrar(tblContactos);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnGuardar_Click(ActionEvent e) {

    }

    private void btnOrdenar_Click(ActionEvent e) {

    }
}
