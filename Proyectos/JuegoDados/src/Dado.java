import java.util.Random;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Dado {

    private int numero; // Número del dado

    public void lanzar(Random r) { // Método para lanzar el dado
        numero = r.nextInt(6) + 1; // Generar un número aleatorio entre 1 y 6
    }

    public void mostrar(JLabel lbl) { // Método para mostrar el número del dado
        String rutaImagenDado = "Img/" + numero + ".jpg"; // Ruta de la imagen del dado
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaImagenDado)); // Cargar la imagen del dado
        lbl.setIcon(imgDado); // Asignar la imagen del dado al JLabel
    }

    public int getNumero() { // Método para obtener el número del dado
        return numero; // Devolver el número del dado
    }

}
