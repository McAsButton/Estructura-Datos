import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Consola
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Introduce dos números para calcular su Multiplicacion Rusa: ");
            System.out.print("Número 1: ");
            int n1 = s.nextInt();
            System.out.print("Número 2: ");
            int n2 = s.nextInt();

            int resultado = multiplicacionRusa(n1, n2);
            System.out.println("El resultado de la Multiplicación Rusa es: " + resultado);

            int resultadoRecursivo = multiplicacionRusaRecursiva(n1, n2);
            System.out.println("El resultado de la Multiplicación Rusa Recursiva es: " + resultadoRecursivo);
        } // El Scanner se cierra automáticamente aquí (try-with-resources)
    }

    private static int multiplicacionRusa(int n1, int n2) {
        int producto = 0; 
        while (n1 > 0) { 
            if (n1 % 2 != 0) { 
                producto += n2;
            }
            n1 = n1 / 2; 
            n2 = n2 * 2; 
        }
        return producto;
    }

    private static int multiplicacionRusaRecursiva(int n1, int n2) {
        if (n1 <= 1) {
            return n1 == 0 ? 0 : n2;
        } else if (n1 % 2 != 0) {
            return n2 + multiplicacionRusaRecursiva(n1 / 2, n2 * 2);
        } else {
            return multiplicacionRusaRecursiva(n1 / 2, n2 * 2);
        }
    }
}