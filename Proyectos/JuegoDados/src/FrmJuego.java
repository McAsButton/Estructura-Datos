import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Random;

// Esta clase crea una ventana para un juego de dados usando JFrame como base.
// Contiene etiquetas (JLabel) para mostrar las imágenes de los dados y los resultados,
// y botones (JButton) para iniciar el juego y lanzar los dados.

public class FrmJuego extends JFrame {

    JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas; // Crear objetos de la clase JLabel globales
    Dado dado1, dado2; // Crear objetos de la clase Dado globales
    int lanzamientos, cenas; // Variables para contar los lanzamientos y las cenas ganadas
    Random r = new Random(); // Crear un objeto de la clase Random para generar números aleatorios

    // Constructor de la clase FrmJuego
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

        // Crear e instanciar objetos de la clase Dado
        dado1 = new Dado(); // Instanciar un objeto de la clase Dado para el primer dado
        dado2 = new Dado(); // Instanciar otro objeto de la clase Dado para el segundo dado

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
        lblLanzamientos.setFont(new Font("Tahoma", Font.BOLD, 72)); // Fuente del texto
        lblLanzamientos.setBackground(Color.BLACK); // Color de fondo
        lblLanzamientos.setForeground(new Color(51, 255, 0)); // Color del texto
        lblLanzamientos.setOpaque(true); // Hacer el fondo visible
        lblLanzamientos.setHorizontalAlignment(SwingConstants.CENTER); // Alineación del texto
        lblLanzamientos.setBounds(50 + 2 * imgDado.getIconWidth(), 40, 100, 100); // Posición y tamaño

        // Configuración de la etiqueta de cenas
        lblCenas.setFont(new Font("Tahoma", Font.BOLD, 72)); // Fuente del texto
        lblCenas.setBackground(Color.BLACK); // Color de fondo
        lblCenas.setForeground(new Color(51, 255, 0)); // Color del texto
        lblCenas.setOpaque(true); // Hacer el fondo visible
        lblCenas.setHorizontalAlignment(SwingConstants.CENTER); // Alineación del texto
        lblCenas.setBounds(160 + 2 * imgDado.getIconWidth(), 40, 100, 100); // Posición y tamaño

        mostrarContadores(); // Mostrar los contadores en las etiquetas

        // Configuración de los botones
        btnIniciar.setBounds(10, 150, 100, 25); // Posición y tamaño del botón "Iniciar"
        btnLanzar.setBounds(120, 150, 100, 25); // Posición y tamaño del botón "Lanzar"

        // Agregar un evento al botón "Iniciar"
        btnIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciar_Click(e); // Llamar al método btnIniciar_Click
            }
            
        });

        // Agregar un evento al botón "Lanzar"
        btnLanzar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnLanzar_Click(e); // Llamar al método btnLanzar_Click
            }
        });

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

    private void mostrarContadores(){
        lblLanzamientos.setText(String.valueOf(lanzamientos)); // Mostrar el número de lanzamientos
        lblCenas.setText(String.valueOf(cenas)); // Mostrar el número de cenas ganadas
    }

    private void btnIniciar_Click(ActionEvent evt){
        lanzamientos = 0; // Inicializar el contador de lanzamientos
        cenas = 0; // Inicializar el contador de cenas ganadas
        mostrarContadores(); // Mostrar los contadores en las etiquetas
    }

    private void btnLanzar_Click(ActionEvent evt){
        dado1.lanzar(r); // Lanzar el primer dado
        dado2.lanzar(r); // Lanzar el segundo dado
        dado1.mostrar(lblDado1); // Mostrar el primer dado
        dado2.mostrar(lblDado2); // Mostrar el segundo dado

        lanzamientos++; // Incrementar el contador de lanzamientos
        // condiciones para ganar una cena
        if(dado1.getNumero()+dado2.getNumero() >= 11){ // Si la suma de los dados es mayor o igual a 11
            cenas++; // Incrementar el contador de cenas ganadas
        }
        mostrarContadores(); // Mostrar los contadores en las etiquetas
    }

}