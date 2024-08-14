import java.awt.*; // Importar clases para diseño gráfico
import java.awt.event.*; // Importar clases para eventos
import javax.swing.*; // Importar clases para componentes gráficos
import javax.swing.table.DefaultTableModel; // Importar modelo de tabla

public class FrmJuego extends JFrame { // Clase principal que hereda de JFrame para crear la ventana

    JTable tblNumeros, tblTabla; // Definir las tablas que se mostrarán en la ventana
    JTextField txtTotalTablas; // Campo de texto para ingresar el número de tablas
    JComboBox<String> cmbTabla; // Combo box para seleccionar una tabla
    JButton btnSacarBalota, btnIniciar; // Botones para sacar balotas e iniciar el juego
    Tabla[] tablas; // Arreglo de objetos Tabla para gestionar múltiples tablas

    public FrmJuego() {
        setSize(500, 302); // Establecer el tamaño de la ventana (ancho x alto)
        setTitle("Juguemos al Bingo"); // Establecer el título de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana

        // Crear objetos gráficos
        btnIniciar = new JButton("Iniciar"); // Crear un botón con el texto "Iniciar"
        btnSacarBalota = new JButton("Sacar Balota"); // Crear un botón con el texto "Sacar Balota"
        JLabel lblTotalTablas = new JLabel("Total Tablas"); // Crear una etiqueta con el texto "Total Tablas"
        JLabel lblTabla = new JLabel("Tabla"); // Crear una etiqueta con el texto "Tabla"
        txtTotalTablas = new JTextField(3); // Crear un campo de texto con un ancho de 3 columnas
        cmbTabla = new JComboBox<>(); // Crear un combo box vacío

        // Crear los modelos de tabla
        DefaultTableModel modeloNumeros = new DefaultTableModel(); // Crear un modelo de tabla para los números
        modeloNumeros.addColumn("B"); // Añadir una columna "B"
        modeloNumeros.addColumn("I"); // Añadir una columna "I"
        modeloNumeros.addColumn("N"); // Añadir una columna "N"
        modeloNumeros.addColumn("G"); // Añadir una columna "G"
        modeloNumeros.addColumn("O"); // Añadir una columna "O"

        // Agregar 15 filas para cubrir los números del 1 al 75
        for (int i = 1; i <= 15; i++) { // Bucle para agregar filas
            modeloNumeros.addRow(new Object[] {null, null , null, null, null}); // Agregar una fila vacía
        }
        
        DefaultTableModel modeloTabla = new DefaultTableModel(); // Crear un modelo de tabla para la tabla del jugador
        modeloTabla.addColumn("B"); // Añadir una columna "B"
        modeloTabla.addColumn("I"); // Añadir una columna "I"
        modeloTabla.addColumn("N"); // Añadir una columna "N"
        modeloTabla.addColumn("G"); // Añadir una columna "G"
        modeloTabla.addColumn("O"); // Añadir una columna "O"

        // Agregar 5 filas para la tabla del jugador
        for (int i = 0; i < 5; i++) { // Bucle para agregar filas
            modeloTabla.addRow(new Object[]{null, null, null, null, null}); // Agregar una fila vacía
        }

        // Crear las tablas utilizando los modelos
        tblNumeros = new JTable(modeloNumeros); // Crear la tabla de números
        tblTabla = new JTable(modeloTabla); // Crear la tabla del jugador

        // Atributos de los objetos gráficos
        btnSacarBalota.setEnabled(false); // Desactivar el botón "Sacar Balota" al inicio
        tblNumeros.setEnabled(false); // Desactivar la tabla de números al inicio
        tblTabla.setEnabled(false); // Desactivar la tabla del jugador al inicio

        // Añadir las tablas a scroll panes para permitir desplazamiento
        JScrollPane scrollNumeros = new JScrollPane(tblNumeros); // Crear un scroll pane para la tabla de números
        JScrollPane scrollTabla = new JScrollPane(tblTabla); // Crear un scroll pane para la tabla del jugador

        // Panel para los elementos de la derecha
        JPanel panelDerecho = new JPanel(); // Crear un panel para los componentes de la derecha
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS)); // Organizar los componentes verticalmente

        // Crear un panel para el primer conjunto de elementos (Botón Iniciar, Total Tablas, Campo de Texto)
        JPanel panelIniciar = new JPanel(); // Crear un panel para el botón "Iniciar" y el campo de texto
        panelIniciar.setLayout(new FlowLayout(FlowLayout.LEFT)); // Organizar los componentes horizontalmente
        panelIniciar.add(btnIniciar); // Añadir el botón "Iniciar" al panel
        panelIniciar.add(Box.createHorizontalStrut(40)); // Añadir espacio horizontal entre los componentes
        panelIniciar.add(lblTotalTablas); // Añadir la etiqueta "Total Tablas" al panel
        panelIniciar.add(txtTotalTablas); // Añadir el campo de texto al panel

        // Añadir los componentes al panel derecho
        panelDerecho.add(panelIniciar);
        
        // Crear un panel para el botón Sacar Balota
        JPanel panelSacarBalota = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Crear un panel con un diseño horizontal
        panelSacarBalota.add(btnSacarBalota); // Añadir el botón "Sacar Balota" al panel

        panelDerecho.add(panelSacarBalota);
        
        // Crear un panel con GridBagLayout para la etiqueta "Tabla" y el ComboBox
        JPanel panelTabla = new JPanel(new GridBagLayout()); // Crear un panel con diseño GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Crear restricciones para el diseño GridBagLayout
        gbc.fill = GridBagConstraints.HORIZONTAL; // Configurar el componente para que se expanda horizontalmente
        gbc.insets = new Insets(5, 5, 5, 5); // Establecer márgenes alrededor de los componentes

        gbc.gridx = 0; // Posicionar la etiqueta en la primera columna
        gbc.gridy = 0; // Posicionar la etiqueta en la primera fila
        panelTabla.add(lblTabla, gbc); // Añadir la etiqueta "Tabla" al panel

        gbc.gridx = 1; // Posicionar el combo box en la segunda columna
        gbc.gridy = 0; // Posicionar el combo box en la primera fila
        gbc.weightx = 1.0; // Permitir que el combo box se expanda horizontalmente
        panelTabla.add(cmbTabla, gbc); // Añadir el combo box al panel
        
        panelDerecho.add(panelTabla); // Añadir el panel de la etiqueta y el combo box al panel derecho
        panelDerecho.add(scrollTabla); // Añadir el scroll pane de la tabla del jugador al panel derecho

        // Crear un panel principal para organizar los dos paneles
        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2)); // Crear un panel con diseño GridLayout (1 fila, 2 columnas)
        panelPrincipal.add(scrollNumeros); // Añadir el scroll pane de la tabla de números (mitad izquierda)
        panelPrincipal.add(panelDerecho); // Añadir el panel derecho (mitad derecha)

        // Añadir el panel principal al JFrame
        add(panelPrincipal);

        // Agregar un evento al botón Iniciar
        btnIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { // Acción a realizar cuando se haga clic en el botón "Iniciar"
                btnIniciar_Click(e); // Llamar al método btnIniciar_Click
            }
        });

        // Agregar un evento al combo box Tabla
        cmbTabla.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { // Acción a realizar cuando se seleccione un elemento del combo box
                cmbTabla_Clic(e); // Llamar al método cmbTabla_Clic
            }
        });

        // Agregar un evento al botón Sacar Balota
        btnSacarBalota.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { // Acción a realizar cuando se haga clic en el botón "Sacar Balota"
                btnSacarBalota_Click(e); // Llamar al método btnSacarBalota_Click
            }
        });
    }
    
    // Método del botón Iniciar
    private void btnIniciar_Click(ActionEvent evt) {
        int totalTablas = 2; // Número predeterminado de tablas
        try {
            totalTablas = Integer.parseInt(txtTotalTablas.getText()); // Obtener el número de tablas del campo de texto
        } catch (Exception ex) {
            txtTotalTablas.setText("2"); // Si ocurre un error, establecer el número de tablas a 2
        }
        tablas = new Tabla[totalTablas]; // Crear un arreglo de objetos Tabla con el tamaño especificado
        cmbTabla.removeAllItems(); // Limpiar los elementos del combo box
        for (int i = 0; i < totalTablas; i++) { // Bucle para inicializar las tablas
            tablas[i] = new Tabla(i); // Crear una nueva tabla
            cmbTabla.addItem("Tabla " + (i + 1)); // Añadir la tabla al combo box
        }
        Cantor.iniciar(); // Iniciar el proceso de selección de balotas
        Cantor.mostrarBalotas(tblNumeros); // Mostrar las balotas en la tabla de números
        btnSacarBalota.setEnabled(true); // Activar el botón "Sacar Balota"
    }

    // Método del combo box Tabla
    private void cmbTabla_Clic(ActionEvent evt) {
        if (cmbTabla.getSelectedIndex() >= 0) { // Verificar si se ha seleccionado una tabla
            tablas[cmbTabla.getSelectedIndex()].mostrar(tblTabla); // Mostrar la tabla seleccionada en la tabla del jugador
        }
    }

    // Método del botón Sacar Balota
    private void btnSacarBalota_Click(ActionEvent evt) {
        if (Cantor.sacarBalota() > 0) { // Verificar si se ha sacado una balota
            Cantor.mostrarBalotas(tblNumeros); // Mostrar las balotas en la tabla de números
            if (cmbTabla.getSelectedIndex() >= 0) { // Verificar si se ha seleccionado una tabla
                tablas[cmbTabla.getSelectedIndex()].mostrar(tblTabla); // Mostrar la tabla seleccionada en la tabla del jugador
            }

            // Verificar bingos y binguitos
            for (int i = 0; i < cmbTabla.getItemCount(); i++) { // Bucle para verificar cada tabla
                if (tablas[i].verificarBingo()) { // Verificar si hay un bingo
                    JOptionPane.showMessageDialog(this, "Bingo en la tabla " + (i + 1)); // Mostrar mensaje de bingo
                } else if (tablas[i].verificarBinguito()) { // Verificar si hay un binguito
                    JOptionPane.showMessageDialog(this, "Binguito en la tabla " + (i + 1)); // Mostrar mensaje de binguito
                }
            }

            if (Cantor.obtenerTotalBalotasSacadas() == 75) { // Verificar si se han sacado todas las balotas
                btnSacarBalota.setEnabled(false); // Desactivar el botón "Sacar Balota"
                JOptionPane.showMessageDialog(this, "Se han sacado todas las balotas"); // Mostrar mensaje de fin de juego
            }        
        }
    }
}
