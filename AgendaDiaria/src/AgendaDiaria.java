import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AgendaDiaria extends JFrame {
    private JTextField txtCompromisso;
    private JSpinner spnDataHora;
    private JTable tabelaCompromissos;
    private DefaultTableModel modeloTabela;
    private JButton btnAdicionar, btnRemover;
    private JPanel painelEntrada;
    private JTextField textField1;

    public AgendaDiaria() {
        setTitle("Agenda Diária");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new FlowLayout());

        txtCompromisso = new JTextField(20);
        painelEntrada.add(new JLabel("Compromisso:"));
        painelEntrada.add(txtCompromisso);

        spnDataHora = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnDataHora, "dd/MM/yyyy HH:mm");
        spnDataHora.setEditor(editor);
        painelEntrada.add(new JLabel("Data e Hora:"));
        painelEntrada.add(spnDataHora);

        btnAdicionar = new JButton("Adicionar Compromisso");
        painelEntrada.add(btnAdicionar);

        add(painelEntrada, BorderLayout.NORTH);

        String[] colunas = {"Data/Hora", "Descrição"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaCompromissos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaCompromissos);
        add(scrollPane, BorderLayout.CENTER);

        btnRemover = new JButton("Remover Compromisso");
        JPanel painelInferior = new JPanel(new FlowLayout());
        painelInferior.add(btnRemover);
        add(painelInferior, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = txtCompromisso.getText().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHora = sdf.format(((SpinnerDateModel) spnDataHora.getModel()).getDate());

                modeloTabela.addRow(new Object[]{dataHora, descricao});
                txtCompromisso.setText("");
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaCompromissos.getSelectedRow();
                if (selectedRow != -1) {
                    modeloTabela.removeRow(selectedRow);

                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgendaDiaria agenda = new AgendaDiaria();
            agenda.setVisible(true);
        });
    }
}
