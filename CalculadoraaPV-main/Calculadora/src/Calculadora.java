import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JPanel panelMain;
    private JTextField txtPrimeroValor;
    private JTextField txtSegundoValor;
    private JButton btnSomar;
    private JTextField txtResultado;
    private JButton btnLimpar;
    private JButton btnSubtrair;
    private JButton btnMultiplicar;
    private JButton btnDividir;

    public Calculadora() {
        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer primeiro = Integer.parseInt(txtPrimeroValor.getText());
                Integer segundo = Integer.parseInt(txtSegundoValor.getText());

                int resultado = primeiro + segundo;

                 txtResultado.setText(String.valueOf(resultado));


                //txtResultado.setText(("Hello World"));
            }
        });
        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer primeiro = Integer.parseInt(txtPrimeroValor.getText());
                Integer segundo = Integer.parseInt(txtSegundoValor.getText());

                int resultado = primeiro - segundo;

                txtResultado.setText(String.valueOf(resultado));
            }
        });
        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer primeiro = Integer.parseInt(txtPrimeroValor.getText());
                Integer segundo = Integer.parseInt(txtSegundoValor.getText());
                int resultado = primeiro * segundo;
                txtResultado.setText(String.valueOf(resultado));
            }
        });
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer primeiro = Integer.parseInt(txtPrimeroValor.getText());
                Integer segundo = Integer.parseInt(txtSegundoValor.getText());
                int resultado = primeiro / segundo;
                txtResultado.setText(String.valueOf(resultado));
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeroValor.setText("");
                txtSegundoValor.setText("");
                txtResultado.setText("");
            }
        });
    }


    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Minha Calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        //frame.setSize(300, 300);
        frame.setVisible(true);
        frame.pack();



    }
}
