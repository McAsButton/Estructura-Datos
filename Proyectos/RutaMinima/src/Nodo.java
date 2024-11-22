import java.util.ArrayList;
import java.util.List;

public class Nodo {

    private String nombre;
    private double valor;
    private List<Nodo> vecinos;
    private List<Double> valores;

    public Nodo(String nombre) {
        this.nombre = nombre;
        vecinos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    @Override
    public boolean equals(Object obj) {
        return nombre.equals(((Nodo) obj).getNombre());
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Nodo> getVecinos() {
        return vecinos;
    }

    public void setVecinos(List<Nodo> vecinos) {
        this.vecinos = vecinos;
    }

    public void agregarVecino(Nodo n, double valor) {
        vecinos.add(n);
        valores.add(valor);
    }
}
