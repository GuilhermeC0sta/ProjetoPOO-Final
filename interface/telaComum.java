import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class telaComum extends JFrame implements ActionListener { // fix
    private JButton locar, editar, mostrar, devolver, verificar, pagarmultas, vermultas,
            verutensilios, mostrarTudo, marca_textobutton, audios, books;
    Invoker invoker = new Invoker();
    int index_user = LoginRegister.index_user;
    JFrame frameMultaPendente = new JFrame();
    JPanel panel6 = new JPanel();
    JButton buttonPGM = new JButton("Pagar Multa");
    Dimension botaoDimensao = new Dimension(250, 30);
    DefinirBotao definirBotao = new DefinirBotao();

    public class IOException extends RuntimeException {
        public IOException(String message) {
            super(message);
        }
    }

    public telaComum() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        audios = new JButton("Mostrar audiobooks");
        definirBotao.definebutton(audios,botaoDimensao);
        audios.addActionListener(this);
        audios.setAlignmentX(Component.CENTER_ALIGNMENT);

        mostrarTudo = new JButton("Mostrar todos os itens locados");
        definirBotao.definebutton(mostrarTudo,botaoDimensao);
        mostrarTudo.addActionListener(this);
        mostrarTudo.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPGM = new JButton("Pagar multa");
        definirBotao.definebutton(buttonPGM,botaoDimensao);
        buttonPGM.addActionListener(this);
        buttonPGM.setAlignmentX(Component.CENTER_ALIGNMENT);

        marca_textobutton = new JButton("Mostrar os utensilios em geral");
        definirBotao.definebutton(marca_textobutton,botaoDimensao);
        marca_textobutton.addActionListener(this);
        marca_textobutton.setAlignmentX(Component.CENTER_ALIGNMENT);

        books = new JButton("Mostrar livros");
        definirBotao.definebutton(books,botaoDimensao);
        books.addActionListener(this);
        books.setAlignmentX(Component.CENTER_ALIGNMENT);

        locar = new JButton("Locar livro/audiobook");
        definirBotao.definebutton(locar,botaoDimensao);
        locar.addActionListener(this);
        panel.add(locar);
        locar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        editar = new JButton("Editar perfil");
        definirBotao.definebutton(editar,botaoDimensao);
        editar.addActionListener(this);
        panel.add(editar);
        editar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        mostrar = new JButton("Mostrar livros/audiobooks disponíveis");
        definirBotao.definebutton(mostrar,botaoDimensao);
        mostrar.addActionListener(this);
        panel.add(mostrar);
        mostrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        devolver = new JButton("Devolver livros/audiobooks locados");
        definirBotao.definebutton(devolver,botaoDimensao);
        devolver.addActionListener(this);
        panel.add(devolver);
        devolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        verificar = new JButton("Verificar livros/audiobooks locados");
        definirBotao.definebutton(verificar,botaoDimensao);
        verificar.addActionListener(this);
        panel.add(verificar);
        verificar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        vermultas = new JButton("Ver multas pendentes");
        definirBotao.definebutton(vermultas,botaoDimensao);
        vermultas.addActionListener(this);
        panel.add(vermultas);
        vermultas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        pagarmultas = new JButton("Pagar multas");
        definirBotao.definebutton(pagarmultas,botaoDimensao);
        pagarmultas.addActionListener(this);
        panel.add(pagarmultas);
        pagarmultas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        verutensilios = new JButton("Ver utensilios disponíveis");
        definirBotao.definebutton(verutensilios,botaoDimensao);
        verutensilios.addActionListener(this);
        panel.add(verutensilios);
        verutensilios.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.setSize(new Dimension(550, 400));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(400, 400)));
        setSize(400, 400);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mostrar) {
            Command Mostrar = new Mostrar();
            invoker.setCommand(Mostrar);
            invoker.executeCommand();
        } else if (e.getSource() == locar) {
            Command LocarCommand = new LocarCommand();
            invoker.setCommand(LocarCommand);
            invoker.executeCommand();
        } else if (e.getSource() == verificar) {
            Command VerificarCommand = new VerificarCommand();
            invoker.setCommand(VerificarCommand);
            invoker.executeCommand();
        } else if (e.getSource() == devolver) {
            Command Devolver = new DevolverCommand();
            invoker.setCommand(Devolver);
            invoker.executeCommand();
        } else if (e.getSource() == editar) {
            Command Editar = new EditarCommand();
            invoker.setCommand(Editar);
            invoker.executeCommand();
        } else if (e.getSource() == verutensilios) {
            Command VerUtensilios = new VerUtensiliosCommand();
            invoker.setCommand(VerUtensilios);
            invoker.executeCommand();
        } else if (e.getSource() == vermultas) {
            Command VerMultas = new VerMultasCommand();
            invoker.setCommand(VerMultas);
            invoker.executeCommand();
        } else if (e.getSource() == pagarmultas) {
            Command PagarMultas = new PagarMultasCommand();
            invoker.setCommand(PagarMultas);
            invoker.executeCommand();
        }

    }

}
