import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DevolverCommand extends JFrame implements Command, ActionListener {

    JTextField codigoField2 = new JTextField();
    JPanel panelDevolver = new JPanel();
    int isbn;
    int index_user = LoginRegister.index_user;

    public void execute() {
        panelDevolver.setLayout(new GridLayout(3, 2)); // GridLayout com 3 linhas e 2 colunas
        panelDevolver.add(new JLabel("Digite o codigo do livro:"));
        panelDevolver.add(codigoField2);

        // Exibe um JOptionPane com as caixas de texto e espera o usuário clicar em OK
        int resultDevolver = JOptionPane.showConfirmDialog(null, panelDevolver, "Devolver",
                JOptionPane.OK_CANCEL_OPTION);
        if (resultDevolver == JOptionPane.OK_OPTION) {
            try {
                isbn = Integer.parseInt(codigoField2.getText());
                System.out.println(LoginRegister.id_user.size());
                if (LoginRegister.id_user.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há livros locados");
                } else {
                    for (int j = 0; j < LoginRegister.id_user.size(); j++) {
                        if (LoginRegister.id_user.get(j) == index_user) {
                            if (isbn == LoginRegister.isbn_locado.get(j)) {
                                LoginRegister.id_devolvido.add(j, index_user);
                                LoginRegister.isbn_devolvido.add(j, isbn);
                                LoginRegister.id_user.remove(j);
                                LoginRegister.isbn_locado.remove(j);
                                JOptionPane.showMessageDialog(null, "Livro " + isbn + " devolvido!");
                                for (int k = 0; k < LoginRegister.livros.size(); k++) {
                                    if (isbn == LoginRegister.livros.get(k).getIsbn()) {
                                        LoginRegister.livros.get(k).returnbookLivro();
                                        break;
                                    }
                                }
                            } else
                                JOptionPane.showMessageDialog(null, "Código ISBN não encontrado");
                        } else if (j == LoginRegister.id_user.size() - 1) {
                            JOptionPane.showMessageDialog(null, "Este livro não foi locado por você");
                        }
                    }

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um ISBN válido no campo de código");
                return;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
