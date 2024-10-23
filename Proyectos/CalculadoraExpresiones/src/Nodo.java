public class Nodo {

    private TipoElemento tipo;
    private String valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(TipoElemento tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoElemento getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public double getValorNumerico() {
        try {
            if(tipo == TipoElemento.CONSTANTE_NUMERICA) {
                return Double.parseDouble(valor);
            }            
        } catch (Exception e) {
        }
        return 0;
    }

}
