
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class VerificarCadastroCommand extends JFrame implements Command, ActionListener {

    public void execute() {

        int auxteste2 = 0;

        if (auxteste2 == 0) {
            auxteste2 = 1;
            JPanel panelCadastros = new JPanel(new GridLayout(0, 4));
            JFrame frameCadastros = new JFrame();
            frameCadastros.setSize(400, 400);
            frameCadastros.add(panelCadastros);
            frameCadastros.setVisible(true);
            frameCadastros.setLocationRelativeTo(null);
            panelCadastros.removeAll(); // remove todos os componentes do painel

            for (conta user : LoginRegister.contas) {
                JLabel NomeLabel = new JLabel("Nome: " + user.getNome());
                JLabel EmailLabel = new JLabel("Email: " + user.getEmail());
                JLabel planoLabel = new JLabel("Plano: \n" + user.getPlano());
                panelCadastros.add(NomeLabel);
                panelCadastros.add(EmailLabel);
                panelCadastros.add(planoLabel);
                panelCadastros.add(Box.createRigidArea(new Dimension(0, 10)));
            }

            panelCadastros.revalidate();
            panelCadastros.repaint();
            frameCadastros.revalidate(); // Atualiza o layout da janela

            // adiciona o WindowListener para a janela
            frameCadastros.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    frameCadastros.dispose(); // apaga a janela
                }
            });
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
