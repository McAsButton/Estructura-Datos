import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Grafo {

    private List<Nodo> nodos;
    private List<Arista> aristas;

    public Grafo() {
        nodos = new ArrayList<Nodo>();
        aristas = new ArrayList<Arista>();
    }

    public void desdeArchivo(String nombreArchivo) {
        BufferedReader br = null;
        try {
            br = Archivo.abrirArchivo(nombreArchivo);
            if (br != null) {
                String linea = br.readLine();
                while (linea != null) {
                    String[] datos = linea.split(",");
                    if (datos.length >= 3) {
                        Nodo nodo1 = new Nodo(datos[0].trim());
                        Nodo nodo2 = new Nodo(datos[1].trim());
                        if (!nodos.contains(nodo1)) {
                            nodos.add(nodo1);
                        }
                        if (!nodos.contains(nodo2)) {
                            nodos.add(nodo2);
                        }
                        double valor = Double.parseDouble(datos[2]);
                        aristas.add(new Arista(nodo1, nodo2, valor));
                        nodo1.agregarVecino(nodo2, valor);
                        nodo2.agregarVecino(nodo1, valor);
                    }
                    linea = br.readLine();
                }
            }
        } catch (Exception ex) {
            
        }
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void mostrarNodos(JTable tbl){
        String[] encabezados = new String[] { "Nombre" };
        String[][] datos = new String[nodos.size()][1];

        int fila = 0;
        for (Nodo nodo : nodos) {
            datos[fila][0] = nodo.getNombre();
            fila++;
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tbl.setModel(dtm);
    }

    public void mostrarNodos(JComboBox<String> cmb){
        cmb.removeAllItems();
        for (Nodo nodo : nodos) {
            cmb.addItem(nodo.getNombre());
        }
    }

    public void mostrarAristas(JTable tbl){
        String[] encabezados = new String[] { "Origen", "Destino", "Distancia" };
        String[][] datos = new String[aristas.size()][3];

        int fila = 0;
        for (Arista arista : aristas) {
            datos[fila][0] = arista.getNodo1().getNombre();
            datos[fila][1] = arista.getNodo2().getNombre();
            datos[fila][2] = String.valueOf(arista.getValor());
            fila++;
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tbl.setModel(dtm);
    }

    

    // ******************** Metodos estaticos ********************

    public static Resultado dijkstra(Grafo g, int inicio){
        Resultado r = new Resultado();

        ColaPrioridad cola = new ColaPrioridad();
        
        cola.encolar(g.getNodos().get(inicio), 0);

        while (!cola.vacia()){
            Nodo n = (Nodo)((ElementoCola) cola.desencolar()).elemento;
            r.agregar(n);
            for (int i = 0; i<n.getVecinos().size(); i++){
                Nodo nVecino = n.getVecinos().get(i);
                if (!r.getNodos().contains(nVecino)){
                    double valorAcumulado = n.getValor() + nVecino.getValores().get(i);
                    if (!cola.contiene(nVecino)){
                        nVecino.setValor(valorAcumulado);
                        cola.encolar(nVecino, valorAcumulado);
                    } else {
                        if (valorAcumulado < nVecino.getValor()){
                            nVecino.setValor(valorAcumulado);
                            cola.eliminar(nVecino);
                            cola.encolar(nVecino, valorAcumulado);
                        }
                    }
                }
            }
        }
        return r;
    }
}
