import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginRegister extends JFrame implements ActionListener {
    public static ArrayList<conta> contas = new ArrayList<conta>();
    public static ArrayList<Livro> livros = new ArrayList<Livro>();
    public static ArrayList<audiobook> audiobook2 = new ArrayList<audiobook>();
    public static ArrayList<utensilios> utensilios = new ArrayList<utensilios>();
    public static ArrayList<Integer> id_user = new ArrayList<>();
    public static ArrayList<Integer> id_userAudio = new ArrayList<>();
    public static ArrayList<Integer> isbn_locado = new ArrayList<>();
    public static ArrayList<Integer> isbn_devolvido = new ArrayList<>();
    public static ArrayList<Integer> audio_locado = new ArrayList<>();
    public static ArrayList<Integer> id_devolvido = new ArrayList<>();
    public static ArrayList<Integer> id_multapendente = new ArrayList<>();
    public static ArrayList<Integer> id_multapaga = new ArrayList<>();
    public static ArrayList<Integer> id_multa = new ArrayList<>();
    ContasManager contasmanager = new ContasManager();

    public int sinal = 0;
    public static int id = 0, index_user;
    public JButton login, register;
    public JTextField usuario, senha;

    public LoginRegister() {
        super("Libraric");

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("C:/Users/Junior/Desktop/Libraric/POO-Interface/interface/lib2.jpg"));
        imageLabel.setPreferredSize(new Dimension(350, 250));
        imagePanel.add(imageLabel);

        panel.add(new JLabel("E-mail:"));
        usuario = new JTextField();
        panel.add(usuario);
        panel.add(new JLabel("Senha:"));
        senha = new JPasswordField();
        panel.add(senha);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        login = new JButton("Login");
        login.addActionListener(this);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(login);

        register = new JButton("Register");
        register.addActionListener(this);
        panel.add(register);

        add(imagePanel, BorderLayout.NORTH);
        add(panel);
        setSize(550, 400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            fazerLogin();
        } else {
            abrirCadastro();
        }
        setLocationRelativeTo(null);
    }

    public void fazerLogin() {
        String nomeUsuario = this.usuario.getText();
        String senha = this.senha.getText();

        conta conta = findUser(nomeUsuario, senha);

        if (conta != null) {
            JOptionPane.showMessageDialog(null, "Logado com sucesso!");
            index_user = getIndexConta(nomeUsuario, senha);
            setExtendedState(JFrame.ICONIFIED);
            exibirTelaInicial(index_user);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario/senha inválidos!");
        }
    }

    public int getIndexConta(String nomeUsuario, String senha) {
        for (int i = 0; i < LoginRegister.contas.size(); i++) {
            if (LoginRegister.contas.get(i).getEmail().equals(nomeUsuario) && LoginRegister.contas.get(i).getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }

    private void abrirCadastro() {
        Reg registro = new Reg();
        registro.setVisible(true);
    }

    private void exibirTelaInicial(int indexConta) {
        TelaInicial telaInicial = new TelaInicial(this);

        String tipoConta = contas.get(indexConta).getPlano();
        EstadoConta estadoConta;
        if (tipoConta.equalsIgnoreCase("administrador")) {
            estadoConta = new EstadoContaAdministrador(telaInicial);
        } else {
            estadoConta = new EstadoContaComum(telaInicial);
        }

        estadoConta.mostrarTela();
    }

    class Reg extends JFrame implements ActionListener {

        private JTextField nome, email, senha;
        private JButton register;
        private JLabel titleLabel;
        private JComboBox<String> plano;

        public Reg() {
            super("Registrar Conta");
            setLayout(new BorderLayout());
            setSize(400, 300);

            JPanel panel = new JPanel(new GridLayout(6, 1));

            JPanel titlePanel = new JPanel();
            titleLabel = new JLabel("Preencha os dados abaixo para criar sua conta");
            titlePanel.add(titleLabel);
            add(titlePanel, BorderLayout.NORTH);

            panel.add(new JLabel("Plano:"));
            DefaultComboBoxModel<String> planoModel = new DefaultComboBoxModel<>();
            planoModel.addElement("comum");
            planoModel.addElement("premium");
            planoModel.addElement("administrador");
            plano = new JComboBox<>(planoModel);
            panel.add(plano);

            panel.add(new JLabel("Email:"));
            email = new JTextField();
            panel.add(email);

            panel.add(new JLabel("Nome:"));
            nome = new JTextField();
            panel.add(nome);

            panel.add(new JLabel("Senha:"));
            senha = new JPasswordField();
            panel.add(senha);

            JPanel panel2 = new JPanel();
            register = new JButton("Registrar");
            register.addActionListener(this);
            panel2.add(register);

            add(panel);
            add(panel2, BorderLayout.SOUTH);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == register) {
                String usuario = nome.getText();
                String email2 = email.getText();
                String plano2 = plano.getSelectedItem().toString();
                String senha2 = senha.getText();

                if (!contasmanager.isEmailValid(email2)) {
                    showError("Esse email é inválido!");
                    return;
                }

                if (checkEmail(email2) != null) {
                    showError("Esse usuário já existe!");
                    return;
                }

                if (senha2.length() < 8) {
                    showError("A senha deve possuir pelo menos 8 caracteres!");
                    return;
                }

                if (usuario.length() < 5) {
                    showError("O usuário precisa ter um username maior que 5 caracteres!");
                    return;
                }

                contasmanager.criarConta(usuario, email2, senha2, plano2);
                dispose();
            }
        }

        private void showError(String message) {
            JOptionPane.showMessageDialog(null, message);
        }
    }

    private conta findUser(String usuario, String senha) {
        for (conta contas : contas) {
            if (contas.getEmail().equals(usuario) && contas.getSenha().equals(senha)) {
                return contas;
            }
        }
        return null;
    }

    private conta checkEmail(String usuario) {
        for (conta contas : contas) {
            if (contas.getEmail().equals(usuario)) {
                return contas;
            }
        }
        return null;
    }

    public class IOException extends RuntimeException {
        public IOException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        new LoginRegister();
    }

    class TelaInicial extends JFrame implements ActionListener {
        private JLabel titleLabel;

        public TelaInicial(LoginRegister loginRegister) {
            super("Tela inicial");
            setLayout(new BorderLayout());
            setSize(400, 400);
            JPanel titlePanel = new JPanel();
            titleLabel = new JLabel("Escolha o que deseja fazer: ");
            titlePanel.add(titleLabel);
            add(titlePanel, BorderLayout.NORTH);
            setLocationRelativeTo(null);

            if (sinal == 0) { // criando informações
                livros.add(new Livro("LivroExemplo", "Guilherme", 10, 0, "luta"));
                livros.add(new Livro("LivroExemplo", "Janio", 1234, 150, "romance"));
                audiobook2.add(new audiobook("audioExemplo", "Micael", 120, 0, "aventura", 25));
                audiobook2.add(new audiobook("audioExemplo", "Castelo", 120, 20, "ação", 255));
                utensilios.add(new postit("FaberCastel", "Azul", 2));
                utensilios.add(new marca_texto("Stabilo Boss", "Roxo", "Sem glitter", 10));
                utensilios.add(new apoio_livros("Maxcril", 10, 10));
                id_multapendente.add(0);
                id_multapendente.add(0);
                sinal++;
            }
        }

        public void actionPerformed(ActionEvent e) {
        }
    }
}
