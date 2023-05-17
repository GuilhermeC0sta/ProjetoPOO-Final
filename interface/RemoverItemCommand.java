import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RemoverItemCommand extends JFrame implements Command, ActionListener {
    int isbn;

    public void execute() {

        JComboBox<String> itemFieldR = new JComboBox<>(new String[] { "Livro", "Audiobook" });
        JTextField codigoFieldR = new JTextField();

        JPanel panelRemover = new JPanel();
        setLocationRelativeTo(null);
        panelRemover.setLayout(new GridLayout(3, 2)); // GridLayout com 3 linhas e 2 colunas
        panelRemover.add(new JLabel("Selecione o item para remover:"));
        panelRemover.add(itemFieldR);
        panelRemover.add(new JLabel("Digite o código do item:"));
        panelRemover.add(codigoFieldR);

        int resultRemover = JOptionPane.showConfirmDialog(null, panelRemover, "Remover",
                JOptionPane.OK_CANCEL_OPTION);

        if (resultRemover == JOptionPane.OK_OPTION) {
            try {
                if (itemFieldR.getSelectedItem().equals("Livro")) {
                    isbn = Integer.parseInt(codigoFieldR.getText());

                    for (int k = 0; k < LoginRegister.livros.size(); k++) {
                        if (isbn == LoginRegister.livros.get(k).getIsbn()) {
                            LoginRegister.livros.remove(k);
                            JOptionPane.showMessageDialog(null, "Livro " + isbn + " removido!");
                        } else if (k == LoginRegister.livros.size() - 1) {
                            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
                        }
                    }

                } else if (itemFieldR.getSelectedItem().equals("Audiobook")) {
                    int codigoR = Integer.parseInt(codigoFieldR.getText());

                    for (int k = 0; k < LoginRegister.audiobook2.size(); k++) {
                        if (codigoR == LoginRegister.audiobook2.get(k).getAudio()) {
                            LoginRegister.audiobook2.remove(k);
                            JOptionPane.showMessageDialog(null, "Audiobook " + codigoR + " removido!");
                        } else if (k == LoginRegister.audiobook2.size() - 1) {
                            JOptionPane.showMessageDialog(null, "Audiobook não encontrado!");
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código inválido. Digite um número válido.");
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
