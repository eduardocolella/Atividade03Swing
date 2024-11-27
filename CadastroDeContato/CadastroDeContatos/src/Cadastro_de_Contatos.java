import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_de_Contatos {
    private JPanel panelMain;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtEmail;
    private JButton btnadicionarcontato;
    private JButton btnlimpar;
    private JList listaContatos;
    private JLabel lblnomes;
    private JLabel lbltelefone;
    private JLabel lblemail;
    private JTextArea txtStatus;
    private JButton btnExcluir;
    private JButton btnAddcontatos;
    private JTextField txtTelefone;
    private JTextField txtNome;
    private JLabel lblnome;

    private String nomes = "";
    private String telefones = "";
    private String email = "";
    private String informacoes = "";
    private ArrayList contatos = new ArrayList();
    private int i = 0;


    DefaultListModel<String> contatinhos = new DefaultListModel<>();

    public Cadastro_de_Contatos() {
        listaContatos.setModel(contatinhos);
        btnAddcontatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nomes = txtnome.getText();
                telefones = txttelefone.getText();
                email = txtEmail.getText();

                if (nomes.isEmpty() || telefones.isEmpty() || email.isEmpty()) {
                    txtStatus.setText("Preencha todos os campos acima");
                } else {
                    i++;
                    informacoes = +i + "° Contato Nome: " + nomes + ", Telefone:  " + telefones + " ,E-mail: " + email;
                    listaContatos.setModel(contatinhos);
                }
            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int excluir = listaContatos.getSelectedIndex();


                if (excluir != -1) {
                    contatos.remove(excluir);
                    contatinhos.removeElement(excluir);
                    txtStatus.setText("Contato removido com sucesso!");
                } else {
                    txtStatus.setText("Selecione um contato para remover.");
                }
            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new Cadastro_de_Contatos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
