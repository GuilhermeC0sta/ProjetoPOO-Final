import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

class PagarMultasCommand extends JFrame implements Command, ActionListener {
    int testemultas = 0;
    int auxteste3 = 0;
    int index_user = LoginRegister.index_user;
    JFrame frameMultaPendente = new JFrame();
    JPanel panel6 = new JPanel();
    JButton buttonPGM = new JButton("Pagar Multa");
    int multaalarme = 0;

    public void execute() {

        if (auxteste3 == 0) {
            auxteste3 = 1;
            JPanel panelMP = new JPanel(new GridLayout(0, 1));
            JFrame frameMP = new JFrame();
            frameMP.setSize(400, 400);
            frameMP.setLocationRelativeTo(null);
            frameMP.add(panelMP);
            panelMP.removeAll();
            buttonPGM.setSize(10, 10);
            multaalarme = 0; // redefine a variável multaalarme para 0

            for (int j = 0; j < LoginRegister.id_multapendente.size(); j++) {
                if (LoginRegister.id_multapendente.get(j) == index_user) {
                    multaalarme = 1;
                    JLabel multalabel = new JLabel("Você possui uma multa não paga");
                    panelMP.add(multalabel);
                }
            }
            if (multaalarme == 0) {
                JOptionPane.showMessageDialog(null, "você não possui multas pendentes");
            }
            panelMP.repaint();
            frameMP.revalidate();
            frameMP.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    frameMP.dispose();
                }
            });
            for (int j = 0; j < LoginRegister.id_multapendente.size(); j++) {
                if (LoginRegister.id_multapendente.get(j) == index_user) {
                    testemultas += 1;
                }
            }
            if (testemultas != 0) {
                panelMP.add(buttonPGM);
            } else {
                JLabel multalabel2 = new JLabel("Você pagou todas suas multas ou não possui multas");
                panelMP.add(multalabel2);
            }
            buttonPGM.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < LoginRegister.id_multapendente.size(); j++) {
                        if (LoginRegister.id_multapendente.get(j) == index_user) {
                            LoginRegister.id_multapaga.add(index_user);
                            LoginRegister.id_multapendente.remove(j);
                            JOptionPane.showMessageDialog(null, "você pagou uma de suas multas");
                        }
                    }
                    frameMP.dispose();
                }
            });
            frameMP.setVisible(true);

        } else {
            frameMultaPendente.setSize(400, 400);
            frameMultaPendente.add(panel6);
            frameMultaPendente.setVisible(true);
            frameMultaPendente.setLocationRelativeTo(null);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
