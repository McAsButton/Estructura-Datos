import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FrmCalculadora extends JFrame {

    private JButton btnProcesar;
    private JButton btnEjecutar;
    private JLabel lblExpresion;
    private JTable tblVariables;
    private JTextField txtExpresion;
    private JTextField txtResultado;

    public FrmCalculadora() {
        lblExpresion = new JLabel();
        txtExpresion = new JTextField();
        tblVariables = new JTable();
        btnProcesar = new JButton();
        btnEjecutar = new JButton();
        txtResultado = new JTextField();

        setSize(400, 400);
        setTitle("Calculadora de Expresiones");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblExpresion.setText("Expresión aritmética:");
        lblExpresion.setBounds(20, 10, 150, 25);
        getContentPane().add(lblExpresion);

        txtExpresion.setBounds(200, 10, 150, 25);
        getContentPane().add(txtExpresion);

        btnProcesar.setText("Procesar");
        btnProcesar.setBounds(20, 50, 150, 25);
        getContentPane().add(btnProcesar);

        tblVariables = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(null, new String[] {});
        tblVariables.setModel(dtm);
        JScrollPane sp = new JScrollPane(tblVariables);
        sp.setBounds(200, 50, 150, 250);
        getContentPane().add(sp);

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setBounds(20, 310, 150, 25);
        getContentPane().add(btnEjecutar);

        txtResultado.setBounds(200, 310, 150, 25);
        txtResultado.setEnabled(false);
        getContentPane().add(txtResultado);

        btnProcesar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnProcesarClick(evt);
            }
        });

        btnEjecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEjecutarClick(evt);
            }
        });
    }

    private void btnProcesarClick(ActionEvent evt) {
        PostFijo.setExpresionInfijo(txtExpresion.getText());
        PostFijo.getExpresionPostfijo();
        System.out.println(PostFijo.getExpresionPostfijo());
        String error = PostFijo.getErrorExpresion();
        if (error.length() > 0) {
            JOptionPane.showMessageDialog(null, error);
        } else {
            PostFijo.mostrarVariables(tblVariables);
        }
    }

    private void btnEjecutarClick(ActionEvent evt) {
        ArbolBinario ab = PostFijo.getArbol();
        if (ab != null) {
            List<String> variables = PostFijo.getVariables();
            List<Double> valores = new ArrayList<>();
            // boolean errorVariable = false;

            if (variables != null) {
                DefaultTableModel dtm = (DefaultTableModel) tblVariables.getModel();
                for (int i = 0; i < variables.size(); i++) {
                    try {
                        valores.add(Double.parseDouble((String) dtm.getValueAt(i, 1)));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "El valor de la variable " + variables.get(i) + " no es válido");
                        // errorVariable = true;
                    }
                }
            }
            // if(!errorVariable){
            txtResultado.setText(String.valueOf(ab.ejecutar(variables, valores)));
            // }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha procesado la expresión");
        }
    }
}