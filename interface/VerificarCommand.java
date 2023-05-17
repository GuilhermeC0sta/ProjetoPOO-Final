import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class VerificarCommand extends JFrame implements Command, ActionListener {
    JButton mostrarTudo = new JButton("Mostrar todos os itens locados");
    int auxteste3 = 0;
    int auxteste = 0;
    int index_user = LoginRegister.index_user;
    JFrame frameVerificar = new JFrame();
    JPanel panel5 = new JPanel();
    JFrame frameLocarA = new JFrame();

    public void execute() {
        frameVerificar.setSize(400, 400);
        frameVerificar.add(panel5);

        panel5.add(mostrarTudo);
        panel5.add(Box.createRigidArea(new Dimension(0, 50)));

        mostrarTudo.setAlignmentX(Component.CENTER_ALIGNMENT);
        frameVerificar.setVisible(true);
        frameVerificar.setLocationRelativeTo(null);

        mostrarTudo.addActionListener(new ActionListener() {
            boolean janelaAberta = false;

            public void actionPerformed(ActionEvent e) {
                if (!janelaAberta) {
                    janelaAberta = true;
                    JPanel panelLocados = new JPanel();
                    frameLocarA.setSize(400, 400);
                    frameLocarA.add(panelLocados);
                    frameLocarA.setVisible(true);
                    frameLocarA.setLocationRelativeTo(null);

                    if (LoginRegister.id_userAudio.size() == 0 && auxteste3 == 0) {

                        JOptionPane.showMessageDialog(null, "NAO HÁ AUDIOS LOCADOS");
                        auxteste3 = 1;
                    } else {

                        for (int k = 0; k < LoginRegister.id_userAudio.size(); k++) {
                            if (LoginRegister.id_userAudio.get(k) == index_user) {
                                JLabel tituloLabel6 = new JLabel("Audios: " + LoginRegister.audio_locado.get(k));
                                panelLocados.add(tituloLabel6);
                                panelLocados.revalidate();
                            }
                        }
                    }
                    if (LoginRegister.id_user.size() == 0 && auxteste == 0) {

                        JOptionPane.showMessageDialog(null, "NAO HÁ LIVROS LOCADOS");
                        auxteste = 1;
                    } else {

                        for (int k = 0; k < LoginRegister.id_user.size(); k++) {
                            if (LoginRegister.id_user.get(k) == index_user) {
                                JLabel tituloLabel2 = new JLabel("Livros: " + LoginRegister.isbn_locado.get(k));
                                System.out.println(LoginRegister.isbn_locado.get(k));
                                panelLocados.add(tituloLabel2);
                                panelLocados.revalidate();
                            }
                        }
                    }

                    frameLocarA.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            janelaAberta = false;
                            frameLocarA.remove(panelLocados);
                            frameLocarA.dispose();
                            janelaAberta = false;
                        }
                    });
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}