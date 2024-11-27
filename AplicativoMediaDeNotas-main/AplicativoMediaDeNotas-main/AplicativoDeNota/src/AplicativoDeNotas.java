import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicativoDeNotas {
    private JTextField txtMediaDeNotas;
    private JTextField txtPrimeiraNota;
    private JButton btnAdicionarNotas;
    private JTextField txtSegundaNota;
    private JButton btnCalcularMedia;
    private JTextField txtResultadoMedia;
    private JButton btnLimpar;
    private JPanel main;
    private Container JPanel;

    public AplicativoDeNotas() {
        btnAdicionarNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer PrimeiraNota = Integer.parseInt(txtPrimeiraNota.getText());
                Integer SegundaNota = Integer.parseInt(txtSegundaNota.getText());
                int resultado = PrimeiraNota + SegundaNota;

                txtResultadoMedia.setText(String.valueOf(resultado));
            }
        });
        btnCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer PrimeiraNota = Integer.parseInt(txtPrimeiraNota.getText());
                Integer SegundaNota = Integer.parseInt(txtSegundaNota.getText());
                int resultado = PrimeiraNota + SegundaNota;

                int mediaDeNotas = resultado / 2;

                txtMediaDeNotas.setText(String.valueOf(mediaDeNotas));
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMediaDeNotas.setText("");
                txtPrimeiraNota.setText("");
                txtSegundaNota.setText("");
                txtResultadoMedia.setText("");
            }
        });
    }
        public static void main(String[] args)
        {
            JFrame frame = new JFrame("Aplicativo de Notas");
            frame.setContentPane(new AplicativoDeNotas().main);
            //frame.setSize(300, 300);
            frame.setVisible(true);
            frame.pack();
    }
}
