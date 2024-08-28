import java.util.Random;
import javax.swing.*;

public class Jugador {
    private final int TOTAL_CARTAS = 10; // Declarar la constante TOTAL_CARTAS
    private final int MARGEN = 10; // Declarar la constante MARGEN
    private final int DISTANCIA = 50; // Declarar la constante DISTANCIA

    private Carta[] cartas = new Carta[TOTAL_CARTAS]; // Declarar un arreglo de cartas

    private Random r = new Random(); // Declarar un objeto de la clase Random

    // Método para repartir las cartas
    public void repartir() {
        // Instanciar las 10 cartas
        int i = 0;
        for (@SuppressWarnings("unused") Carta c : cartas) {
            cartas[i++] = new Carta(r); // Crear una nueva carta
        }
    }

    // Método para mostrar las cartas en un panel
    public void mostrarCartas(JPanel pnl) {
        pnl.removeAll(); // Eliminar todos los componentes del panel
        int x = 0; // Inicializar la variable x
        for (Carta c : cartas) { // Recorrer todas las cartas
            c.mostrar(pnl, MARGEN + x++ * DISTANCIA, MARGEN); // Mostrar la carta en el panel
        }
        pnl.repaint(); // Volver a pintar el panel
    }

    // Método para verificar los grupos de cartas
    public String getGrupos(){
        String mensaje = "No se encontraron grupos"; // Inicializar el mensaje default
        int[] contadores = new int[NombreCarta.values().length]; // Declarar un arreglo de contadores

        // Contar las cartas de cada tipo
        for (Carta c : cartas) {
            contadores[c.getNombre().ordinal()]++; // Incrementar el contador de la carta
        }

        boolean hayGrupos = false;  // Declarar una variable para indicar si hay grupos
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                if (!hayGrupos) {
                    hayGrupos = true;
                    mensaje = "Los grupos encontrados son:\n";
                }
                mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
            }
        }
        return mensaje;
    }
}
