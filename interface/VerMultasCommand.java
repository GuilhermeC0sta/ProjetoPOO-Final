import javax.swing.*;
import java.awt.event.*;

class VerMultasCommand extends JFrame implements Command, ActionListener {
    int auxteste3 = 0;
    int index_user = LoginRegister.index_user;
    JFrame frameMultaPendente = new JFrame();
    JPanel panel6 = new JPanel();
    JButton multa_pendente = new JButton("Ver Multas Pendentes");
    int multaalarme = 0;

    public void execute() {

        if (auxteste3 == 0) {
            auxteste3 = 1;
            JPanel panelMP = new JPanel();
            JFrame frameMP = new JFrame();
            frameMP.setSize(400, 400);
            frameMP.setLocationRelativeTo(null);
            frameMP.add(panelMP);
            panelMP.removeAll();
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

            frameMP.setVisible(true);
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
