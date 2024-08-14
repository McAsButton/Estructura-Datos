import java.util.Random; // Importar clase para generar números aleatorios
import javax.swing.*; // Importar clases para componentes gráficos
import javax.swing.table.*; // Importar clases para modelos de tabla

public class Tabla {
    // Generador de números aleatorios
    private Random r;
    // Matriz de números de la tabla
    private int[][] tabla;

    // Constructor de la clase Tabla
    public Tabla(int numero) {
        // Inicializar el generador de números aleatorios con una semilla basada en la hora actual y el número del jugador
        r = new Random(System.currentTimeMillis() * numero); // Semilla
        // Crear una matriz de 5x5 para la tabla del bingo
        tabla = new int[5][5];
        // Llenar la tabla con números aleatorios
        for (int f = 0; f < 5; f++) { // Iterar sobre las filas
            for (int c = 0; c < 5; c++) { // Iterar sobre las columnas
                tabla[f][c] = 0; // Inicializar el valor de la celda en 0
                // Ubicación diferente del centro de la tabla
                if (f != 2 || c != 2) { // Verificar si no es la celda central
                    while (tabla[f][c] == 0) { // Mientras la celda esté vacía
                        // Generar un número aleatorio para la celda basado en su columna
                        numero = (c * 15) + r.nextInt(14) + 1;
                        // Verificar si el número ya está en la columna
                        if (!verificarNumero(numero, c)) {
                            tabla[f][c] = numero; // Asignar el número a la celda
                        }
                    }
                }
            }
        }
    }

    // Método para verificar si un número ya está en la columna de la tabla
    private boolean verificarNumero(int numero, int columna) {
        int f = 0;
        boolean encontrado = false;
        while (f < 5 && !encontrado) { // Iterar sobre las filas de la columna
            if (tabla[f][columna] == numero) { // Verificar si el número ya está en la columna
                encontrado = true; // Número encontrado
            } else {
                f++;
            }
        }
        return encontrado; // Retornar si el número fue encontrado
    }

    // Método que devuelve la matriz de la tabla
    public int[][] obtenerTabla() {
        return tabla; // Retornar la matriz de números de la tabla
    }

    // Método que muestra los datos de la tabla en un JTable
    public void mostrar(JTable tbl) {
        int f = tabla.length; // Número de filas
        int c = tabla[0].length; // Número de columnas
        // Convertir los números enteros en textos
        String[][] m = new String[f][c];
        for (int i = 0; i < f; i++) { // Iterar sobre las filas
            for (int j = 0; j < c; j++) { // Iterar sobre las columnas
                String valor = String.valueOf(tabla[i][j]); // Convertir el número a texto
                if (i != 2 || j != 2) { // Verificar si no es la celda central
                    m[i][j] = valor; // Asignar el valor a la matriz de texto
                    // Verificar si el número ha sido sacado
                    if (Cantor.verificarSacada(tabla[i][j])) {
                        m[i][j] = "*" + valor + "*"; // Marcar el número como sacado
                    }
                }
            }
        }
        // Configurar el modelo de la tabla con los datos de la tabla del bingo
        tbl.setModel(new DefaultTableModel(m, Cantor.obtenerEncabezados()));
    }

    // Método que verifica si se ha presentado un Bingo
    public boolean verificarBingo() {
        boolean bingo = true; // Suponer inicialmente que hay bingo
        int ft = 0;
        while (ft < 5 && bingo) { // Iterar sobre las filas
            int c = 0;
            while (c < 5 && bingo) { // Iterar sobre las columnas
                if (ft != 2 || c != 2) { // Verificar si no es la celda central
                    bingo = false; // Suponer inicialmente que no hay bingo
                    int fb = 0;
                    while (fb < 15 && !bingo) { // Iterar sobre las balotas
                        if (tabla[ft][c] == Cantor.obtenerBalotas()[fb][c]) { // Verificar si el número en la tabla está en las balotas
                            bingo = true; // Bingo encontrado
                        } else {
                            fb++;
                        }
                    }
                }
                c++;
            }
            ft++;
        }
        return bingo; // Retornar si se encontró un bingo
    }

    // Método que verifica si se ha presentado un Binguito
    public boolean verificarBinguito() {
        boolean binguito = false; // Suponer inicialmente que no hay binguito
        // Buscar binguito por filas
        int c, fb;
        int ft = 0;
        while (ft < 5 && !binguito) { // Iterar sobre las filas
            c = 0;
            while (c < 5 && binguito) { // Iterar sobre las columnas
                if (ft != 2 || c != 2) { // Verificar si no es la celda central
                    binguito = false; // Suponer inicialmente que no hay binguito
                    fb = 0;
                    while (fb < 15 && !binguito) { // Iterar sobre las balotas
                        if (tabla[ft][c] == Cantor.obtenerBalotas()[fb][c]) { // Verificar si el número en la tabla está en las balotas
                            binguito = true; // Binguito encontrado
                        } else {
                            fb++;
                        }
                    }
                }
                c++;
            }
            ft++;
        }
        if (!binguito) {
            // Buscar binguito por columnas
            c = 0;
            while (c < 5 && !binguito) { // Iterar sobre las columnas
                ft = 0;
                binguito = true; // Suponer que hay binguito
                while (ft < 5 && binguito) { // Iterar sobre las filas
                    if (ft != 2 || c != 2) { // Verificar si no es la celda central
                        binguito = false; // Suponer inicialmente que no hay binguito
                        fb = 0;
                        while (fb < 15 && !binguito) { // Iterar sobre las balotas
                            if (tabla[ft][c] == Cantor.obtenerBalotas()[fb][c]) { // Verificar si el número en la tabla está en las balotas
                                binguito = true; // Binguito encontrado
                            } else {
                                fb++;
                            }
                        }
                    }
                    ft++;
                }
                c++;
            }
        }
        if (!binguito) {
            // Buscar binguito por diagonal principal
            ft = 0;
            c = 0;
            binguito = true; // Suponer que hay binguito
            while (ft < 5 && binguito) { // Iterar sobre la diagonal principal
                if (ft != 2 || c != 2) { // Verificar si no es la celda central
                    binguito = false; // Suponer inicialmente que no hay binguito
                    fb = 0;
                    while (fb < 15 && !binguito) { // Iterar sobre las balotas
                        if (tabla[ft][c] == Cantor.obtenerBalotas()[fb][c]) { // Verificar si el número en la tabla está en las balotas
                            binguito = true; // Binguito encontrado
                        } else {
                            fb++;
                        }
                    }
                }
                ft++;
                c++;
            }
        }
        if (!binguito) {
            // Buscar binguito por diagonal secundaria
            ft = 0;
            c = 4;
            binguito = true; // Suponer que hay binguito
            while (ft < 5 && binguito) { // Iterar sobre la diagonal secundaria
                if (ft != 2 || c != 2) { // Verificar si no es la celda central
                    binguito = false; // Suponer inicialmente que no hay binguito
                    fb = 0;
                    while (fb < 15 && !binguito) { // Iterar sobre las balotas
                        if (tabla[ft][c] == Cantor.obtenerBalotas()[fb][c]) { // Verificar si el número en la tabla está en las balotas
                            binguito = true; // Binguito encontrado
                        } else {
                            fb++;
                        }
                    }
                }
                ft++;
                c--;
            }
        }
        return binguito; // Retornar si se encontró un binguito
    }
}
