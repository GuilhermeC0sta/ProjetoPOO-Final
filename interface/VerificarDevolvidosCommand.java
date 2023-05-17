import javax.swing.*;
import java.awt.event.*;
import java.util.*;


class VerificarDevolvidosCommand extends JFrame implements Command, ActionListener {
    List<Integer> ids_a_remover = new ArrayList<Integer>();

    public void execute() {

        for (int j = 0; j < LoginRegister.id_devolvido.size(); j++) {
            String mensagem = "O usuário de id " + LoginRegister.id_devolvido.get(j) + " devolveu o livro "
                    + LoginRegister.isbn_devolvido.get(j)
                    + ".\nSe este livro foi devolvido, clique em OK.\nCaso contrário, clique em CANCELAR.";
            int resultado = JOptionPane.showConfirmDialog(null, mensagem, "Livro devolvido",
                    JOptionPane.OK_CANCEL_OPTION);
            if (resultado == JOptionPane.OK_OPTION) {
                LoginRegister.id_devolvido.remove(j);
                LoginRegister.isbn_devolvido.remove(j);
                JOptionPane.showMessageDialog(null, "Confirmado que o livro foi devolvido!");
            } else if (resultado == JOptionPane.CANCEL_OPTION) {
                if (!LoginRegister.id_multa.contains(LoginRegister.id_devolvido.get(j))) {
                    String mensagemMulta = "Aplicar multa? Digite S para aplicar multa caso tenha passado o prazo, ou N caso contrário.";
                    String resposta = JOptionPane.showInputDialog(null, mensagemMulta, "Multa",
                            JOptionPane.QUESTION_MESSAGE);
                    boolean multado = false;
                    if (resposta != null && resposta.equalsIgnoreCase("S")) {
                        JOptionPane.showMessageDialog(null, "Multa aplicada!");
                        LoginRegister.id_multa.add(LoginRegister.id_devolvido.get(j));
                        multado = true;
                    } else if (resposta != null && resposta.equalsIgnoreCase("N")) {
                        JOptionPane.showMessageDialog(null, "Multa não aplicada!");
                        multado = true;
                    }
                    if (multado) {
                        for (int k = 0; k < ids_a_remover.size(); k++) {
                            int id = ids_a_remover.get(k);
                            if (id == LoginRegister.id_devolvido.get(j)) {
                                ids_a_remover.remove(k);
                                break;
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário já foi multado!");
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
