import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class VerUtensiliosCommand extends JFrame implements Command, ActionListener {

    int auxteste3 = 0;
    int auxteste2 = 0;
    int auxteste = 0;
    JFrame frameUtensilio = new JFrame();
    JPanel panel6 = new JPanel();
    JButton marca_textobutton = new JButton("Ver Utensilios");


    public void execute() {
        frameUtensilio.setSize(400, 400);
        frameUtensilio.add(panel6);
        panel6.add(marca_textobutton);

        marca_textobutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        frameUtensilio.setVisible(true);
        frameUtensilio.setLocationRelativeTo(null);

        marca_textobutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (auxteste == 0) {
                    auxteste = 1;
                    JPanel panelUten = new JPanel(new GridLayout(0, 1));
                    JFrame frameUten = new JFrame();
                    frameUten.setSize(400, 400);
                    frameUten.add(panelUten);
                    frameUten.setVisible(true);
                    panelUten.removeAll(); // remove todos os componentes do painel

                    for (utensilios utensi : LoginRegister.utensilios) {
                        JLabel corlabel = new JLabel("" + utensi.getInformacao());
                        // adicionar componentes ao painel central
                        panelUten.add(corlabel);
                    }

                    panelUten.revalidate();
                    panelUten.repaint();
                    frameUten.revalidate(); // Atualiza o layout da janela

                    // adiciona o WindowListener para a janela
                    frameUten.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            frameUten.dispose(); // apaga a janela
                        }
                    });
                }
                auxteste3 = 0;
                auxteste2 = 0;
                auxteste = 0;
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
