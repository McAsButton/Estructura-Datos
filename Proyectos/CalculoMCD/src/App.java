import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Consola
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Introduce dos números para calcular su MCD: ");
            System.out.print("Número 1: ");
            int n1 = s.nextInt();
            System.out.print("Número 2: ");
            int n2 = s.nextInt();

            int mcd = calcularMCD(n1, n2);
            int mdcR = calcularMCDRecursivo(n1, n2);
            
            System.out.println(String.format("El MCD de %d y %d es %d", n1, n2, mcd));
            System.out.println(String.format("El MCD recursivo de %d y %d es %d", n1, n2, mdcR));
        } // El Scanner se cierra automáticamente aquí (try-with-resources)
    }

    // Método para calcular el MCD de dos números (no recursivo)
    private static int calcularMCD(int n1, int n2) {
        int r = n1 % n2;
        while (r != 0) {
            n1 = n2;
            n2 = r;
            r = n1 % n2;
        }
        return n2;
    }

    // Método para calcular el MCD de dos números (recursivo)
    private static int calcularMCDRecursivo(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return calcularMCDRecursivo(n2, n1 % n2);
        }
    }
}
