import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC {
    private JPanel panelMain;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnCalcular;
    private JTextField txtValorIMC;
    private JTextField txtClassificacao;
    private JButton btnLimpar;

    public CalculadoraIMC() {

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer peso = Integer.valueOf(txtPeso.getText());
                Double altura = Double.valueOf(txtAltura.getText());

                double imc = peso / (altura * altura);
                txtValorIMC.setText(String.valueOf(imc));
                if (imc < 18.5) {
                    txtClassificacao.setText("Abaixo do peso");
                } else if (imc >= 18.5 && imc < 24.9) {
                    txtClassificacao.setText("Peso normal");
                } else if (imc >= 25 && imc < 29.9) {
                    txtClassificacao.setText("Sobrepeso");
                } else {
                    txtClassificacao.setText("Obesidade");
                }

            }

        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPeso.setText("");
                txtAltura.setText("");
                txtValorIMC.setText("");
                txtClassificacao.setText("");
            }
        });
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("CalculadoraIMC");
        frame.setContentPane(new CalculadoraIMC().panelMain);
        //frame.setSize(300, 300);
        frame.setVisible(true);
        frame.pack();



    }
}

