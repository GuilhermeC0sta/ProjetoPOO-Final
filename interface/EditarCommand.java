import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

class EditarCommand extends JFrame implements Command, ActionListener {

    // Cria caixas de texto para nome, email e bio
    JPanel panelEditar = new JPanel();
    int index_user = LoginRegister.index_user;
    JTextField nomeField = new JTextField(LoginRegister.contas.get(index_user).getNome());
    JTextField emailField = new JTextField(LoginRegister.contas.get(index_user).getEmail());
    JTextField bioField = new JTextField(20);
    JLabel bioMsg = new JLabel("BIO - Comum = 50 caracteres; Premium = 200 caracteres");

    public void execute() {

        panelEditar.setLayout(new GridLayout(4, 2));
        panelEditar.add(new JLabel("Nome:"));
        panelEditar.add(nomeField);
        panelEditar.add(new JLabel("E-mail:"));
        panelEditar.add(emailField);
        panelEditar.add(new JLabel("Bio:"));
        panelEditar.add(bioField);
        panelEditar.add(bioMsg);

        // Exibe um JOptionPane com as caixas de texto e espera o usuário clicar em OK
        int result = JOptionPane.showConfirmDialog(null, panelEditar, "Editar perfil",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Obtém o texto digitado nas caixas de texto
            String nome = nomeField.getText();
            String email = emailField.getText();
            String bio = bioField.getText();

            if (nome.length() < 5) {
                JOptionPane.showMessageDialog(null,
                        "O usuário precisa ter um username maior que 5 caracteres!");
            }

            else if ((checkEmail(email) != null || isEmailValid(email) == false)
                    && !email.equalsIgnoreCase(LoginRegister.contas.get(index_user).getEmail())) {
                JOptionPane.showMessageDialog(null,
                        "E-mail inválido ou já cadastrado!");
            } else if (LoginRegister.contas.get(index_user).getPlano().equalsIgnoreCase("comum")) {

                if (bio.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Você excedeu o número de caracteres");
                } else if (bio == "00") {
                } else {
                    LoginRegister.contas.get(index_user).defBios(bio);
                }
                LoginRegister.contas.set(index_user,
                        new comum(email, LoginRegister.contas.get(index_user).getSenha(), nome, index_user)); // antes
                // era
                // id
                LoginRegister.contas.get(index_user).defPlano("comum");
                JOptionPane.showMessageDialog(null, "Nome e email alterados com sucesso!");
            }

            else if (LoginRegister.contas.get(index_user).getPlano().equalsIgnoreCase("premium")) {

                if (bio.length() > 200) {
                    JOptionPane.showMessageDialog(null, "Você excedeu o número de caracteres");
                } else if (bio == "00") {
                } else {
                    LoginRegister.contas.get(index_user).defBios(bio);
                }
                String SenhaString = LoginRegister.contas.get(index_user).getSenha();

                LoginRegister.contas.set(index_user,
                        new premium(email, SenhaString, nome, LoginRegister.index_user)); // antes
                LoginRegister.contas.get(index_user).defPlano("premium");
                JOptionPane.showMessageDialog(null, "Nome e email alterados com sucesso!");
            }
        }

    }

    private conta checkEmail(String usuario) {
        for (conta contas : LoginRegister.contas) {
            if (contas.getEmail().equals(usuario)) {
                return contas;
            }
        }
        return null;
    }

    public static boolean isEmailValid(String email) {
        String[] allowedDomains = { "gmail.com", "outlook.com", "hotmail.com", "ic.ufal.br" };
        String regex = "^[A-Za-z0-9+_.-]+@(" + String.join("|", allowedDomains) + ")$";
        Pattern pattern = Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}