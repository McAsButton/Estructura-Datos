import java.util.List;

public class ArbolBinario {

    Nodo raiz;

    private List<String> variables;
    private List<Double> valores;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo n) {
        raiz = n;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public String PreOrden(Nodo n) {
        if (n != null) {
            return n.getValor() + " " + PreOrden(n.izquierdo) + " " + PreOrden(n.derecho);
        }
        return "";
    }

    public String InOrden(Nodo n) {
        if (n != null) {
            return InOrden(n.izquierdo) + " " + n.getValor() + " " + InOrden(n.derecho);
        }
        return "";
    }

    public String PostOrden(Nodo n) {
        if (n != null) {
            return PostOrden(n.izquierdo) + " " + PostOrden(n.derecho) + " " + n.getValor();
        }
        return "";
    }

    private double getValorVariable(String variable) {
        if (variables.size() > 0) {
            int posicion = variables.indexOf(variable);
            if (posicion >= 0 && posicion < valores.size()) {
                return valores.get(posicion);
            }
        }
        return 0;
    }

    private double getValorNodo(Nodo n) {
        return n.getTipo() == TipoElemento.CONSTANTE_NUMERICA ? n.getValorNumerico() : getValorVariable(n.getValor());
    }

    private double ejecutarNodo(Nodo n) {
        if (n.izquierdo == null && n.derecho == null) {
            return getValorNodo(n);
        } else {
            double operando1 = ejecutarNodo(n.izquierdo);
            double operando2 = ejecutarNodo(n.derecho);
            switch (n.getValor()) {
                case "+":
                    return operando1 + operando2;
                case "-":
                    return operando1 - operando2;
                case "*":
                    return operando1 * operando2;
                case "/":
                    return operando2 != 0 ? operando1 / operando2 : 0;
                case "%":
                    return operando2 != 0 ? operando1 % operando2 : 0;
                case "^":
                    return Math.pow(operando1, operando2);
            }
        }
        return 0;
    }

    public double ejecutar(List<String> variables, List<Double> valores) {
        this.variables = variables;
        this.valores = valores;
        return ejecutarNodo(raiz);
    }
}
