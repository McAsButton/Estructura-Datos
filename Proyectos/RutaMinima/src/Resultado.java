import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Resultado {

    private List<Nodo> nodos;

    public Resultado(){
        nodos = new ArrayList<>();
    }

    //Agregar un nodo al nodos
    public void agregar(Nodo n){
        nodos.add(n);
    }

    //Mostrar nodos del nodos
    public void mostrar(JTable tbl, boolean mostrarTotal){
        if (nodos != null){
            String[][] datos;
            if (mostrarTotal){
                datos = new String[nodos.size() + 1][2];
            } else {
                datos = new String[nodos.size()][2];
            }
            double valorTotal = 0;
            for (int i = 0; i < nodos.size(); i++){
                datos [i][0] = nodos.get(i).getNombre();
                datos [i][1] = String.valueOf(nodos.get(i).getValor());
                valorTotal += nodos.get(i).getValor();
            }
            if (mostrarTotal){
                datos[nodos.size()][0] = "Valor Total";
                datos[nodos.size()][1] = String.valueOf(valorTotal);
            }
            DefaultTableModel dtm = new DefaultTableModel(datos, new String[] { "Nombre", "Valor" });
            tbl.setModel(dtm);
        }
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

}
