import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeContatos extends JFrame {
    private JTextField txtNome, txtTelefone, txtEmail;
    private DefaultListModel<String> listaContatosModel;
    private JList<String> listaContatos;
    private JButton btnAdicionar, btnRemover;
    private JPanel panelMain;

    public CadastroDeContatos() {
        setTitle("Cadastro de Contatos");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(4, 2, 10, 10));

        panelMain.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelMain.add(txtNome);

        panelMain.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        panelMain.add(txtTelefone);

        panelMain.add(new JLabel("E-mail:"));
        txtEmail = new JTextField();
        panelMain.add(txtEmail);

        btnAdicionar = new JButton("Adicionar Contato");
        panelMain.add(btnAdicionar);

        add(panelMain, BorderLayout.NORTH);

        listaContatosModel = new DefaultListModel<>();
        listaContatos = new JList<>(listaContatosModel);
        JScrollPane scrollPane = new JScrollPane(listaContatos);
        add(scrollPane, BorderLayout.CENTER);

        btnRemover = new JButton("Remover Contato");
        JPanel painelInferior = new JPanel();
        painelInferior.add(btnRemover);
        add(painelInferior, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String telefone = txtTelefone.getText().trim();
                String email = txtEmail.getText().trim();

                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            CadastroDeContatos.this,
                            "Preencha todos os campos!",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                String contato = String.format("Nome: %s | Telefone: %s | E-mail: %s", nome, telefone, email);
                listaContatosModel.addElement(contato);
                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaContatos.getSelectedIndex();
                if (selectedIndex != -1) {
                    listaContatosModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(
                            CadastroDeContatos.this,
                            "Selecione um contato para remover!",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroDeContatos frame = new CadastroDeContatos();
            frame.setVisible(true);
        });
    }
}