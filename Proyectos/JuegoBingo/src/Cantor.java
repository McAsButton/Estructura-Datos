import java.util.Random; // Importar clase para generar números aleatorios
import javax.swing.*; // Importar clases para componentes gráficos
import javax.swing.table.*; // Importar clases para modelos de tabla

public abstract class Cantor {
    // Encabezados de las columnas de la tabla de balotas
    private static String[] encabezados = new String[] { "B", "I", "N", "G", "O" };
    // Matriz que almacena las balotas sacadas
    private static int[][] balotas = new int[15][5];
    // Contador de balotas sacadas
    private static int totalBalotasSacadas;
    // Generador de números aleatorios
    private static Random r = new Random();

    // Método que inicializa las balotas como no sacadas
    public static void iniciar() {
        // Inicializar todas las posiciones en la matriz de balotas a 0
        for (int c = 0; c < 5; c++) {
            for (int f = 0; f < 15; f++) {
                balotas[f][c] = 0; // Indicar que la balota no ha sido sacada
            }
        }
        // Establecer el total de balotas sacadas a 0
        totalBalotasSacadas = 0;
    }

    // Método que simula el sacar una balota de manera aleatoria
    public static int sacarBalota() {
        int numero = 0;
        // Asegurarse de no sacar más de 75 balotas
        if (totalBalotasSacadas < 75) {
            boolean sacada = false;
            while (!sacada) {
                // Generar un número aleatorio entre 1 y 75
                numero = r.nextInt(75) + 1;
                // Calcular la fila y columna de la balota
                int f = numero % 15;
                if (f == 0) {
                    f = 15;
                }
                int c = (numero - f) / 15;
                // Verificar si la balota ya ha sido sacada
                if (balotas[f - 1][c] == 0) {
                    sacada = true; // La balota es válida y no ha sido sacada
                    balotas[f - 1][c] = numero; // Marcar la balota como sacada
                    totalBalotasSacadas++; // Incrementar el total de balotas sacadas
                }
            }
        }
        return numero; // Retornar el número de la balota sacada
    }

    // Método para mostrar las balotas que han sido sacadas en un JTable
    public static void mostrarBalotas(JTable tbl) {
        int f = balotas.length; // Número de filas
        int c = balotas[0].length; // Número de columnas
        // Convertir los números de las balotas a texto
        String[][] m = new String[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (balotas[i][j] == 0) {
                    m[i][j] = ""; // Si la balota no ha sido sacada, dejar la celda vacía
                } else {
                    m[i][j] = String.valueOf(balotas[i][j]); // Convertir el número a texto
                }
            }
        }
        // Configurar el modelo de la tabla con los datos de las balotas
        tbl.setModel(new DefaultTableModel(m, encabezados));
    }

    // Método que verifica si una balota ya ha sido sacada
    public static boolean verificarSacada(int numero) {
        // Verificar si ya se han sacado balotas
        if (totalBalotasSacadas > 0) {
            int f = numero % 15;
            if (f == 0) {
                f = 15;
            }
            int c = (numero - f) / 15;
            // Verificar si la balota está en la matriz de balotas sacadas
            if (balotas[f - 1][c] == 0) {
                return false; // La balota no ha sido sacada
            } else {
                return true; // La balota ha sido sacada
            }
        } else {
            return false; // No se han sacado balotas
        }
    }

    // Método que devuelve los encabezados de las tablas
    public static String[] obtenerEncabezados() {
        return encabezados; // Retornar los encabezados de las columnas
    }

    // Método que devuelve la matriz de balotas sacadas
    public static int[][] obtenerBalotas() {
        return balotas; // Retornar la matriz de balotas sacadas
    }

    // Método que devuelve la cantidad total de balotas sacadas
    public static int obtenerTotalBalotasSacadas() {
        return totalBalotasSacadas; // Retornar el total de balotas sacadas
    }
}
