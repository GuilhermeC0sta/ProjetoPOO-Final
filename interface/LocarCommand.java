import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LocarCommand extends JFrame implements Command, ActionListener{
    int contalocados = 0;
    int index_user = LoginRegister.index_user;
    public static int codiguin;
    public void execute() {
        JComboBox<String> itemField;
            JTextField codigoField = new JTextField(20);
            JPanel panelLocar = new JPanel();
            setLocationRelativeTo(null);
            panelLocar.setLayout(new GridLayout(3, 2));
            panelLocar.add(new JLabel("Digite se quer um livro/audiobook:"));
            DefaultComboBoxModel<String> planoModel = new DefaultComboBoxModel<>();
            planoModel.addElement("livro");
            planoModel.addElement("audiobook");
            itemField = new JComboBox<>(planoModel);
            panelLocar.add(itemField);
            panelLocar.add(new JLabel("Digite o codigo do livro/audiobook:"));
            panelLocar.add(codigoField);
            int resultLocar = JOptionPane.showConfirmDialog(null, panelLocar, "Locar",
            JOptionPane.OK_CANCEL_OPTION);
            contalocados = 0;
            if (resultLocar == JOptionPane.OK_OPTION) {
                for (int k = 0; k < LoginRegister.id_user.size(); k++) {
                    if (LoginRegister.id_user.get(k) == index_user) {
                        contalocados += 1;
                    }
                }

                if (LoginRegister.contas.get(index_user).getPlano().equalsIgnoreCase("comum")) {
                    if (contalocados < 1) {
                        String itemType = itemField.getSelectedItem().toString();
                        codiguin = Integer.parseInt(codigoField.getText());
                        if (itemType.equalsIgnoreCase("livro") || itemType.equalsIgnoreCase("audiobook")) {
                            locarItem(itemType, codiguin);
                        }
                        contalocados += 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não pode locar mais de um item pois a sua conta é comum");
                    }
                }

                if (LoginRegister.contas.get(index_user).getPlano().equalsIgnoreCase("premium")) {
                    if (contalocados < 15) {
                        String itemType = itemField.getSelectedItem().toString();
                        int codiguin = Integer.parseInt(codigoField.getText());
                        if (itemType.equalsIgnoreCase("livro") || itemType.equalsIgnoreCase("audiobook")) {
                            locarItem(itemType, codiguin);
                        }
                        contalocados += 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Você só pode locar até no máximo 15 itens");
                    }
                }
            }
        }

        public void locarItem(String item, int codigo) {
            try {
                if (item.equalsIgnoreCase("livro")) {
                    for (int k = 0; k < LoginRegister.livros.size(); k++) {
                        if (codigo == LoginRegister.livros.get(k).getIsbn()) {
                            LoginRegister.livros.get(k).RentLivro();
                        } else if (k == LoginRegister.livros.size() - 1) {
                            JOptionPane.showMessageDialog(null, "Código ISBN não encontrado.");
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < LoginRegister.audiobook2.size(); k++) {
                        if (codigo == LoginRegister.audiobook2.get(k).getAudio()) {
                            if (LoginRegister.audiobook2.get(k).isAvailable() == false) {
                                JOptionPane.showMessageDialog(null,
                                        "Audiobook indisponível, tente novamente em outro momento.");
                                break;
                            } else if (LoginRegister.audiobook2.get(k).isAvailable()) {
                                LoginRegister.audiobook2.get(k).rent();
                                JOptionPane.showMessageDialog(null, "Parabéns, você conseguiu locar um audiobook!");
                                LoginRegister.id_userAudio.add(index_user);
                                LoginRegister.audio_locado.add(codigo);
                                break;
                            }
                        } else if (k == LoginRegister.audiobook2.size() - 1) {
                            JOptionPane.showMessageDialog(null, "Código do audiobook não encontrado.");
                            break;
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                if (item.equalsIgnoreCase("livro")) {
                    JOptionPane.showMessageDialog(null, "Código ISBN inválido.");
                } else {
                    JOptionPane.showMessageDialog(null, "Código do audiobook inválido.");
                }
            }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
