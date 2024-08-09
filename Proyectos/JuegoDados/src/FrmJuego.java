import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.Color;

// Esta clase crea una ventana para un juego de dados usando JFrame como base.
// Contiene etiquetas (JLabel) para mostrar las imágenes de los dados y los resultados,
// y botones (JButton) para iniciar el juego y lanzar los dados.

public class FrmJuego extends JFrame {

    JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas; // Crear objetos de la clase JLabel globales

    public FrmJuego() {
        setSize(600, 300); // Tamaño de la ventana
        setTitle("Juguemos a los dados"); // Título de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Terminar ejecución al cerrar la ventana

        // Crear e instanciar objetos locales para los componentes gráficos        
        lblDado1 = new JLabel(); // Instanciar objeto de la clase JLabel para mostrar un dado
        lblDado2 = new JLabel(); // Instanciar otro JLabel para el segundo dado
        JLabel jLabel1 = new JLabel(); // Etiqueta para el texto "Lanzamientos"
        JLabel jLabel2 = new JLabel(); // Etiqueta para el texto "Cenas"
        lblLanzamientos = new JLabel(); // Etiqueta que mostrará el número de lanzamientos
        lblCenas = new JLabel(); // Etiqueta que mostrará el número de cenas ganadas
        JButton btnIniciar = new JButton("Iniciar"); // Botón para iniciar el juego
        JButton btnLanzar = new JButton("Lanzar"); // Botón para lanzar los dados

        // Configuración de las etiquetas de los dados
        String rutaImagenDado = "Img/1.jpg"; // Ruta de la imagen del dado
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaImagenDado)); // Cargar la imagen del dado
        lblDado1.setIcon(imgDado); // Asignar la imagen del dado al JLabel lblDado1
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight()); // Posición y tamaño del JLabel
        lblDado2.setIcon(imgDado); // Asignar la imagen al JLabel lblDado2
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight()); // Posición y tamaño

        // Configuración de las etiquetas de texto
        jLabel1.setText("Lanzamientos"); // Texto de la etiqueta para "Lanzamientos"
        jLabel1.setBounds(50 + 2 * imgDado.getIconWidth(), 10, 100, 25); // Posición y tamaño de la etiqueta
        jLabel2.setText("Cenas"); // Texto de la etiqueta para "Cenas"
        jLabel2.setBounds(160 + 2 * imgDado.getIconWidth(), 10, 100, 25); // Posición y tamaño de la etiqueta

        // Configuración de la etiqueta de lanzamientos
        lblLanzamientos.setText("0"); // Texto inicial
        lblLanzamientos.setFont(new Font("Tahoma", Font.BOLD, 72)); // Fuente del texto
        lblLanzamientos.setBackground(Color.BLACK); // Color de fondo
        lblLanzamientos.setForeground(new Color(51, 255, 0)); // Color del texto
        lblLanzamientos.setOpaque(true); // Hacer el fondo visible
        lblLanzamientos.setHorizontalAlignment(SwingConstants.CENTER); // Alineación del texto
        lblLanzamientos.setBounds(50 + 2 * imgDado.getIconWidth(), 40, 100, 100); // Posición y tamaño

        // Configuración de la etiqueta de cenas
        lblCenas.setText("0"); // Texto inicial
        lblCenas.setFont(new Font("Tahoma", Font.BOLD, 72)); // Fuente del texto
        lblCenas.setBackground(Color.BLACK); // Color de fondo
        lblCenas.setForeground(new Color(51, 255, 0)); // Color del texto
        lblCenas.setOpaque(true); // Hacer el fondo visible
        lblCenas.setHorizontalAlignment(SwingConstants.CENTER); // Alineación del texto
        lblCenas.setBounds(160 + 2 * imgDado.getIconWidth(), 40, 100, 100); // Posición y tamaño

        // Configuración de los botones
        btnIniciar.setBounds(10, 150, 100, 25); // Posición y tamaño del botón "Iniciar"
        btnLanzar.setBounds(120, 150, 100, 25); // Posición y tamaño del botón "Lanzar"

        // Agregar todos los componentes al contenedor de la ventana
        getContentPane().setLayout(null); // Desactivar el diseño automático para posicionar manualmente
        getContentPane().add(lblDado1); // Agregar lblDado1 al contenedor
        getContentPane().add(lblDado2); // Agregar lblDado2 al contenedor
        getContentPane().add(jLabel1); // Agregar jLabel1 al contenedor
        getContentPane().add(jLabel2); // Agregar jLabel2 al contenedor
        getContentPane().add(lblLanzamientos); // Agregar lblLanzamientos al contenedor
        getContentPane().add(lblCenas); // Agregar lblCenas al contenedor
        getContentPane().add(btnIniciar); // Agregar btnIniciar al contenedor
        getContentPane().add(btnLanzar); // Agregar btnLanzar al contenedor
    }

}