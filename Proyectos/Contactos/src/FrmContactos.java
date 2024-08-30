import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

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

        JScrollPane jspContactos = new JScrollPane(tblContactos);

        getContentPane().add(jtbContactos, "North");
        getContentPane().add(jspContactos, "Center");

        String nombreArchivo = System.getProperty("user.dir") + "/Proyectos/Contactos/src/Data/Datos.txt";

        lContactos.desdeArchivo(nombreArchivo);
        lContactos.mostrar(tblContactos);
    }

}
