import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class AddItemCommand extends JFrame implements Command, ActionListener {

    public void execute() {

        String[] opcoes = { "Livro", "Audiobook", "Utensilio" };
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione o tipo de item a adicionar:",
                "Adicionar Itens", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes,
                opcoes[0]);

        if (opcaoSelecionada == 0) { // Clicou em "Livro"
            JTextField tituloAdd = new JTextField();
            JTextField autorAdd = new JTextField();
            JTextField isbnAdd = new JTextField();
            JTextField generoAdd = new JTextField();
            JTextField quantidadeAdd = new JTextField();
            JPanel panelItens = new JPanel(new GridLayout(0, 1));
            setLocationRelativeTo(null);

            panelItens.add(new JLabel("Titulo:"));
            panelItens.add(tituloAdd);
            panelItens.add(new JLabel("Autor:"));
            panelItens.add(autorAdd);
            panelItens.add(new JLabel("ISBN:"));
            panelItens.add(isbnAdd);
            panelItens.add(new JLabel("Gênero:"));
            panelItens.add(generoAdd);
            panelItens.add(new JLabel("Quantidade:"));
            panelItens.add(quantidadeAdd);
            int result = JOptionPane.showConfirmDialog(null, panelItens, "Adicionar Livro",
                    JOptionPane.OK_CANCEL_OPTION);
            try {
                int isbnAddItem = Integer.parseInt(isbnAdd.getText());
                int quantidadeAddItem = Integer.parseInt(quantidadeAdd.getText());
                for (int i = 0; i < LoginRegister.livros.size(); i++) {
                    if (LoginRegister.livros.get(i).getIsbn() == isbnAddItem) {
                        JOptionPane.showMessageDialog(null, "ISBN já cadastrado!");
                        return;
                    }
                }

                if (!autorAdd.getText().matches("[a-zA-Z]+") || !generoAdd.getText().matches("[a-zA-Z]+")) {
                    throw new IOException("O campo autor/gênero deve conter somente letras.");
                }

                if (result == JOptionPane.OK_OPTION) {
                    LoginRegister.livros.add(
                            new Livro(tituloAdd.getText(), autorAdd.getText(), isbnAddItem, quantidadeAddItem,
                                    generoAdd.getText()));
                    JOptionPane.showMessageDialog(null, "Livro adicionado!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ISBN e Quantidade devem ser números inteiros!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } else if (opcaoSelecionada == 1) { // Clicou em "Audiobook"
            JTextField tituloAdd = new JTextField();
            JTextField autorAdd = new JTextField();
            JTextField duracaoAdd = new JTextField();
            JTextField generoAdd = new JTextField();
            JTextField quantidadeAdd = new JTextField();
            JTextField idAudioAdd = new JTextField();

            JPanel panelItens = new JPanel(new GridLayout(0, 1));
            int duracaoAddItem = 0;
            int quantidadeAddItem = 0;
            int idAudioAddItem = 0;
            setLocationRelativeTo(null);

            panelItens.add(new JLabel("Titulo:"));
            panelItens.add(tituloAdd);
            panelItens.add(new JLabel("Autor:"));
            panelItens.add(autorAdd);
            panelItens.add(new JLabel("Duração:"));
            panelItens.add(duracaoAdd);
            panelItens.add(new JLabel("Gênero:"));
            panelItens.add(generoAdd);
            panelItens.add(new JLabel("Quantidade:"));
            panelItens.add(quantidadeAdd);
            panelItens.add(new JLabel("ID do Áudio:"));
            panelItens.add(idAudioAdd);

            int result = JOptionPane.showConfirmDialog(null, panelItens, "Adicionar Audiobook",
                    JOptionPane.OK_CANCEL_OPTION);

            try {
                duracaoAddItem = Integer.parseInt(duracaoAdd.getText());
                quantidadeAddItem = Integer.parseInt(quantidadeAdd.getText());
                idAudioAddItem = Integer.parseInt(idAudioAdd.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ISBN, Quantidade e Duração devem ser números inteiros!");
                return;
            }

            if (result == JOptionPane.OK_OPTION) {
                for (int i = 0; i < LoginRegister.audiobook2.size(); i++) {
                    if (LoginRegister.audiobook2.get(i).getAudio() == idAudioAddItem) {
                        JOptionPane.showMessageDialog(null, "ID do áudio já cadastrado!");
                        return;
                    }
                }
                LoginRegister.audiobook2.add(new audiobook(tituloAdd.getText(), autorAdd.getText(), duracaoAddItem,
                        quantidadeAddItem,
                        generoAdd.getText(), idAudioAddItem));
                JOptionPane.showMessageDialog(null, "Audio adicionado!");
            }
        } else if (opcaoSelecionada == 2) { // Clicou em "Utensilio"
            String[] options = { "Postit", "Marca texto", "Apoio de livros" };
            int utensilioOption = JOptionPane.showOptionDialog(null, "Escolha o utensílio a adicionar:",
                    "Adicionar Utensílio", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
                    options[0]);

            if (utensilioOption == 0) { // Adicionar Postit
                JTextField corField = new JTextField();
                JTextField marcaField = new JTextField();
                JTextField quantidadeField = new JTextField();
                JPanel panelP = new JPanel(new GridLayout(0, 1));
                try {
                    panelP.add(new JLabel("Cor:"));
                    panelP.add(corField);
                    panelP.add(new JLabel("Marca:"));
                    panelP.add(marcaField);
                    panelP.add(new JLabel("Quantidade:"));
                    panelP.add(quantidadeField);
                    int result = JOptionPane.showConfirmDialog(null, panelP, "Adicionar Postit",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (!corField.getText().matches("[a-zA-Z]+")) {
                        throw new IOException("O campo cor deve conter somente letras.");
                    }

                    if (result == JOptionPane.OK_OPTION) {
                        // Adicionar postit ao inventário com os dados preenchidos
                        String corP = corField.getText();
                        String marcaP = marcaField.getText();
                        int quantidadeP = Integer.parseInt(quantidadeField.getText());
                        LoginRegister.utensilios.add(new postit(marcaP, corP, quantidadeP));
                        JOptionPane.showMessageDialog(null, "Postit adicionado!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Quantidade deve ser um número inteiro!");
                    return;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            } else if (utensilioOption == 1) { // Adicionar Marca Texto
                JTextField marcaField = new JTextField();
                JTextField corField = new JTextField();
                JTextField brilhoField = new JTextField();
                JTextField quantidadeField = new JTextField();
                JPanel panelM = new JPanel(new GridLayout(0, 1));
                try {

                    panelM.add(new JLabel("Marca:"));
                    panelM.add(marcaField);
                    panelM.add(new JLabel("Cor:"));
                    panelM.add(corField);
                    panelM.add(new JLabel("Brilho:"));
                    panelM.add(brilhoField);
                    panelM.add(new JLabel("Quantidade:"));
                    panelM.add(quantidadeField);
                    int result = JOptionPane.showConfirmDialog(null, panelM, "Adicionar Marca Texto",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (!corField.getText().matches("[a-zA-Z]+")
                            || !brilhoField.getText().matches("[a-zA-Z]+")) {
                        throw new IOException("O campo cor/brilho deve conter somente letras.");
                    }

                    if (result == JOptionPane.OK_OPTION) {
                        // Adicionar marca texto ao inventário com os dados preenchidos
                        String marcaM = marcaField.getText();
                        String corM = corField.getText();
                        String brilhoM = brilhoField.getText();
                        int quantidadeM = Integer.parseInt(quantidadeField.getText());
                        LoginRegister.utensilios.add(new marca_texto(marcaM, corM, brilhoM, quantidadeM));
                        JOptionPane.showMessageDialog(null, "Marca texto adicionado!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Quantidade deve ser um número inteiro!");
                    return;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            } else if (utensilioOption == 2) { // Adicionar Apoio de Livros
                JTextField marcaField = new JTextField();
                JTextField slotsField = new JTextField();
                JTextField quantidadeField = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                try {

                    panel.add(new JLabel("Marca:"));
                    panel.add(marcaField);
                    panel.add(new JLabel("Slots:"));
                    panel.add(slotsField);
                    panel.add(new JLabel("Quantidade:"));
                    panel.add(quantidadeField);
                    int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Apoio de Livros",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        // Adicionar apoio de livros ao inventário com os dados preenchidos
                        String marcaA = marcaField.getText();
                        int slotsA = Integer.parseInt(slotsField.getText());
                        int quantidadeA = Integer.parseInt(quantidadeField.getText());
                        LoginRegister.utensilios.add(new apoio_livros(marcaA, slotsA, quantidadeA));
                        JOptionPane.showMessageDialog(null, "Apoio para Livros adicionado!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Slots e Quantidade devem ser números inteiros!");
                    return;
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
