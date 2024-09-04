import java.io.BufferedReader;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Lista {
    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    public void agregar(Nodo n) {
        if (n != null) {
            if (cabeza == null) {
                cabeza = n;
            } else {
                Nodo apuntador = cabeza;
                while (apuntador.siguiente != null) {
                    apuntador = apuntador.siguiente;
                }
                apuntador.siguiente = n;
            }
            n.siguiente = null;
        }
    }

    public Nodo obtener(int posicion){
        int contador = 0;
        Nodo apuntador = cabeza;
        while (apuntador != null && contador < posicion) {
            contador++;
            apuntador = apuntador.siguiente;
        }
        return contador == posicion && apuntador != null ? apuntador : null;

    }

    public void eliminar(Nodo n){
        if (n != null && cabeza != null) {
            boolean encontrado = false;
            Nodo apuntador = cabeza;
            Nodo anterior = null;
            while (apuntador != null && !encontrado) {
                if (apuntador == n) {
                    encontrado = true;
                } else {
                    anterior = apuntador;
                    apuntador = apuntador.siguiente;
                }
            }
            if (encontrado) {
                if (anterior == null) {
                    cabeza = apuntador.siguiente;
                } else {
                    anterior.siguiente = apuntador.siguiente;
                }
            }
        }

    }

    public void desdeArchivo(String nombreArchivo) {
        BufferedReader br = Archivo.abrirArchivo(nombreArchivo);
        try {
            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split("\t");
                if (datos.length >= 5) {
                    Nodo n = new Nodo(datos[0], datos[1], datos[2], datos[3], datos[4]);
                    agregar(n);
                }
                linea = br.readLine();
            }
        } catch (Exception ex) {

        }
    }

    public int getLongitud(){
        int totalNodos = 0;
        Nodo apuntador = cabeza;
        while (apuntador != null) {
            totalNodos++;
            apuntador = apuntador.siguiente;
        }
        return totalNodos;
    }

    public void mostrar(JTable tbl){
        String[] encabezados = {"Nombre", "Telefono", "Celular", "Direccion", "Correo"};
        String[][] datos = new String[getLongitud()][5];

        int fila = 0;
        Nodo apuntador = cabeza;
        while (apuntador != null) {
            datos[fila][0] = apuntador.nombre;
            datos[fila][1] = apuntador.telefono;
            datos[fila][2] = apuntador.celular;
            datos[fila][3] = apuntador.direccion;
            datos[fila][4] = apuntador.correo;
            
            fila++;
            apuntador = apuntador.siguiente;
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tbl.setModel(dtm);
    }
}
