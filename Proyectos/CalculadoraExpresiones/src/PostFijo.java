import java.util.Stack;

import javax.swing.JTable;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

public class PostFijo {

    private static String expresionInfijo;
    private static String expresionPostfijo;
    private static String errorExpresion;

    public static String getErrorExpresion() {
        return errorExpresion;
    }

    public static void setExpresionInfijo(String expresionInfijo) {
        PostFijo.expresionInfijo = expresionInfijo;
    }

    public static String getExpresionPostfijo() {
        expresionPostfijo = "";
        expresionInfijo = expresionInfijo.replace(" ", "");
        errorExpresion = "";

        Stack<String> pila = new Stack<String>();
        boolean error = false;
        int i = 0;
        int parentesis = 0;
        TipoElemento tipo = TipoElemento.OPERADOR;

        while (i < expresionInfijo.length() && !error) {
            String caracter = expresionInfijo.substring(i, i + 1);

            if (caracter.equals("(")) {
                pila.push(caracter);
                tipo = TipoElemento.PARENTESIS_IZQUIERDO;
                parentesis++;
            } else if (caracter.equals(")")) {
                tipo = TipoElemento.PARENTESIS_DERECHO;
                if (parentesis == 0) {
                    error = true;
                    errorExpresion = "Hace falta paréntesis izquierdo";
                } else {
                    parentesis--;
                    caracter = (String) pila.peek();
                    while (!pila.isEmpty() && !caracter.equals("(")) {
                        expresionPostfijo += " " + pila.pop();
                        caracter = (String) pila.peek();
                    }
                    pila.pop();
                }
            } else if (esOperador(caracter)) {
                if (caracter.equals("-")
                        && (tipo == TipoElemento.PARENTESIS_IZQUIERDO || tipo == TipoElemento.OPERADOR || i == 0)) {
                    // Detectar operador unario
                    pila.push(caracter);
                    expresionPostfijo += "0 ";
                } else {
                    // Detectar operadores binarios
                    if (tipo.ordinal() < 2) {
                        error = true;
                        errorExpresion = "Hace falta operando antes de " + caracter;
                    } else {
                        tipo = TipoElemento.OPERADOR;
                        expresionPostfijo += " ";
                        while (!pila.empty() && esPredecesor((String) pila.peek(), caracter)) {
                            expresionPostfijo += (String) pila.pop();
                        }
                        pila.push(caracter);
                    }
                }
            } else if (esLetra(caracter) || esDigito(caracter)) {
                tipo = TipoElemento.OPERANDO;
                expresionPostfijo += caracter;
            } else {
                error = true;
                errorExpresion = "el carácter '" + caracter + "' no válido";
            }
            i++;
        }
        if (!error && parentesis > 0) {
            error = true;
            errorExpresion = "Hace falta paréntesis derecho";
        } else if (i == 0 || tipo == TipoElemento.OPERADOR) {
            error = true;
            errorExpresion = "No hay expresión o falta operando";
        }
        if (error) {
            expresionPostfijo = "";
        } else {
            while (!pila.empty()) {
                expresionPostfijo += " ";
                expresionPostfijo += pila.pop();
            }
        }
        return expresionPostfijo;
    }

    public static List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        boolean error = false;
        if (expresionPostfijo != null && expresionPostfijo.length() > 0) {

            TipoElemento tipo = TipoElemento.OPERADOR;
            int i = 0;
            String texto = "";
            while (i < expresionPostfijo.length() && !error) {
                String caracter = expresionPostfijo.substring(i, i + 1);

                if (esLetra(caracter) && tipo == TipoElemento.CONSTANTE_NUMERICA) {
                    error = true;
                    errorExpresion = "Las constantes numéricas solo puede contener dígitos";
                } else if ((esLetra(caracter) && tipo.ordinal() < TipoElemento.CONSTANTE_NUMERICA.ordinal())
                        || (esDigito(caracter) && tipo == TipoElemento.VARIABLE)) {
                    tipo = TipoElemento.VARIABLE;
                    texto += caracter;
                } else if (esDigito(caracter) && tipo != TipoElemento.VARIABLE) {
                    tipo = TipoElemento.CONSTANTE_NUMERICA;
                    texto += caracter;
                } else if (caracter.equals(" ") && tipo == TipoElemento.VARIABLE) {
                    if (!variables.contains(texto)) {
                        variables.add(texto);
                    }
                    texto = "";
                    tipo = TipoElemento.OPERADOR;
                } else if (caracter.equals(" ") && tipo == TipoElemento.CONSTANTE_NUMERICA) {
                    texto = "";
                    tipo = TipoElemento.OPERADOR;
                }
                i++;
            }
        } else {
            error = true;
            errorExpresion = "No hay expresión";
        }
        return error ? null : variables;
    }

    public static void mostrarVariables(JTable tbl) {
        List<String> variables = getVariables();
        String[] encabezados = new String[] { "Variable", "Valor" };
        String[][] datos = null;
        if (variables != null) {
            datos = new String[variables.size()][encabezados.length];
            for (int i = 0; i < variables.size(); i++) {
                datos[i][0] = variables.get(i);
            }
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tbl.setModel(dtm);

    }

    public static ArbolBinario getArbol() {
        boolean error = false;
        Stack<Nodo> pila = new Stack<>();
        if (expresionPostfijo != null && expresionPostfijo.length() > 0) {
            TipoElemento tipo = TipoElemento.OPERADOR;
            int i = 0;
            String texto = "";
            while (i < expresionPostfijo.length() && !error) {
                String caracter = expresionPostfijo.substring(i, i + 1);

                if (esLetra(caracter) && tipo == TipoElemento.CONSTANTE_NUMERICA) {
                    error = true;
                    errorExpresion = "Las constantes numéricas solo puede contener dígitos";
                } else if ((esLetra(caracter) && tipo.ordinal() < TipoElemento.CONSTANTE_NUMERICA.ordinal())
                        || (esDigito(caracter) && tipo == TipoElemento.VARIABLE)) {
                    tipo = TipoElemento.VARIABLE;
                    texto += caracter;
                } else if (esDigito(caracter) && tipo != TipoElemento.VARIABLE) {
                    tipo = TipoElemento.CONSTANTE_NUMERICA;
                    texto += caracter;
                } else if (caracter.equals(" ") && tipo != TipoElemento.OPERADOR) {
                    Nodo nOperando = new Nodo(tipo, texto);
                    pila.push(nOperando);
                    texto = "";
                    tipo = TipoElemento.OPERADOR;
                } else if (esOperador(caracter)) {
                    Nodo nOperador = new Nodo(tipo, caracter);
                    Nodo nDererecho = (Nodo) pila.pop();
                    Nodo nIzquierdo = (Nodo) pila.pop();
                    nOperador.izquierdo = nIzquierdo;
                    nOperador.derecho = nDererecho;
                    pila.push(nOperador);
                }
                i++;
            }
        } else {
            error = true;
            errorExpresion = "No hay expresión";
        }
        return error ? null : new ArbolBinario((Nodo) pila.pop());
    }

    public static boolean esLetra(String caracter) {
        return caracter.matches("[a-zA-Z]");
    }

    public static boolean esDigito(String caracter) {
        return caracter.matches("[0-9]");
    }

    public static boolean esOperador(String caracter) {
        String caracteres = "+-*/%^";
        return caracteres.contains(caracter);
    }

    public static boolean esPredecesor(String operador1, String operador2) {
        boolean p = false;
        if (operador1.equals("^"))
            p = true;
        else if (operador1.equals("%")) {
            if (!operador2.equals("^"))
                p = true;
        } else if (operador1.equals("/") || operador1.equals("*")) {
            if (!operador2.equals("^") && !operador2.equals("%"))
                p = true;
        } else if (operador1.equals("-") || operador1.equals("+")) {
            {
                if (operador2.equals("+") || operador2.equals("-"))
                    p = true;
            }
        }
        return p;
    }

}
