import javax.swing.JFrame;

public abstract class EstadoConta {
    protected JFrame telaInicial;

    public EstadoConta(JFrame home) {
        this.telaInicial = home;
    }
    

    public abstract void mostrarTela();
}
