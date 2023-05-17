import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ConfirmarCommand extends JFrame implements Command, ActionListener {

    public void execute() {

        JButton buttonCP;
        buttonCP = new JButton("Confirmar Pagamento");
        int auxteste2 = 0;
        JFrame frameMultaPendente = new JFrame();
        JPanel panel6 = new JPanel();

        if (auxteste2 == 0) {
            JPanel panelCP = new JPanel(new GridLayout(0, 1));
            JFrame frameCP = new JFrame();
            frameCP.setSize(400, 400);
            frameCP.add(panelCP);
            frameCP.setLocationRelativeTo(null);
            panelCP.removeAll();
            buttonCP.setSize(10, 10);
            int multaalarme = 0; // redefine a variável multaalarme para 0

            for (int j = 0; j < LoginRegister.id_multapaga.size(); j++) {
                multaalarme = 1;
                JLabel multalabel = new JLabel("O Usuario: " + LoginRegister.id_multapaga.get(j) + " pagou uma multa");
                panelCP.add(multalabel);
            }
            if (multaalarme == 0) {
                JOptionPane.showMessageDialog(null, "Não há multas para serem pagas");
            }
            panelCP.repaint();
            frameCP.revalidate();
            frameCP.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    frameCP.dispose();
                }
            });
            if (LoginRegister.id_multapaga.size() != 0) {
                panelCP.add(buttonCP);
            } else {
                JLabel multalabel2 = new JLabel("Não há multas a serem confirmadas");
                panelCP.add(multalabel2);
            }
            buttonCP.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < LoginRegister.id_multapaga.size(); j++) {
                        LoginRegister.id_multapaga.remove(j);
                        JOptionPane.showMessageDialog(null, "voce confirmou o pagamento de uma das multas");
                    }
                    frameCP.dispose();
                }
            });
            frameCP.setVisible(true);

        } else {
            frameMultaPendente.setSize(400, 400);
            frameMultaPendente.add(panel6);
            frameMultaPendente.setVisible(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
