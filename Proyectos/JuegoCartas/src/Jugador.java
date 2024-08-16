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
}
