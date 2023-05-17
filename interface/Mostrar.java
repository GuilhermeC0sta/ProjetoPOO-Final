import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Mostrar extends JFrame implements Command, ActionListener  {
    public void execute() {
        JFrame frameMostrar = new JFrame();
        JPanel panel3 = new JPanel();
        JButton books, audios;
        Dimension botaoDimensao = new Dimension(250, 30);
        
        audios = new JButton("Mostrar audiobooks");
        audios.setPreferredSize(botaoDimensao);
        audios.setMaximumSize(botaoDimensao);
        audios.setMinimumSize(botaoDimensao);
        audios.addActionListener(this);
        audios.setAlignmentX(Component.CENTER_ALIGNMENT);

        books = new JButton("Mostrar livros");
        books.setPreferredSize(botaoDimensao);
        books.setMaximumSize(botaoDimensao);
        books.setMinimumSize(botaoDimensao);
        books.addActionListener(this);
        books.setAlignmentX(Component.CENTER_ALIGNMENT);
        frameMostrar.setSize(400, 400);
            frameMostrar.add(panel3);
            panel3.add(books);
            panel3.add(Box.createRigidArea(new Dimension(0, 50)));
            panel3.add(audios);

            books.setAlignmentX(Component.CENTER_ALIGNMENT);
            audios.setAlignmentX(Component.CENTER_ALIGNMENT);
            frameMostrar.setVisible(true);
            frameMostrar.setLocationRelativeTo(null);

            books.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JPanel panel4 = new JPanel(new GridLayout(0, 3));
                    JFrame frameLocar2 = new JFrame();
                    frameLocar2.setSize(400, 400);
                    frameLocar2.add(panel4);
                    frameLocar2.setVisible(true);
                    frameLocar2.setLocationRelativeTo(null);
                    panel4.removeAll();
                    for (Livro livro : LoginRegister.livros) {
                        if (livro instanceof Livro) {
                            JLabel tituloLabel2 = new JLabel("Título: " + livro.getTitulo());
                            JLabel isbnLabel = new JLabel("ISBN: " + livro.getIsbn());
                            JLabel qntdLabel = new JLabel("Quantidade: " + livro.getQnt_disp());
                            panel4.add(tituloLabel2);
                            panel4.add(isbnLabel);
                            panel4.add(qntdLabel);
                        }
                    }

                    panel4.revalidate();
                    panel4.repaint();
                    frameLocar2.revalidate();
                    frameLocar2.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            frameLocar2.dispose(); // apaga a janela
                        }
                    });
                }
            });

            audios.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JPanel panel4 = new JPanel(new GridLayout(0, 3));
                    JFrame frameLocar3 = new JFrame();
                    frameLocar3.setSize(400, 400);
                    frameLocar3.add(panel4);
                    frameLocar3.setVisible(true);
                    frameLocar3.setLocationRelativeTo(null);
                    for (audiobook audio : LoginRegister.audiobook2) {
                        if (audio instanceof audiobook) {
                            JLabel tituloLabel3 = new JLabel("Título: " + audio.getTitulo());
                            JLabel codigoLabel = new JLabel("Codigo do áudio: " + audio.getAudio());
                            JLabel qntdLabel3 = new JLabel("Quantidade: " + audio.getQnt_disp());
                            // adicionar componentes ao painel central
                            panel4.add(tituloLabel3);
                            panel4.add(codigoLabel);
                            panel4.add(qntdLabel3);

                            panel4.revalidate();
                            panel4.repaint();
                            frameLocar3.revalidate(); 
                        }
                    }
                    frameLocar3.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            frameLocar3.dispose();
                        }
                    });
                }
            });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
