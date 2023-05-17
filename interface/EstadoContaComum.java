public class EstadoContaComum extends EstadoConta {
    public EstadoContaComum(LoginRegister.TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public void mostrarTela() {
        telaComum novatela = new telaComum();
        novatela.setVisible(true);
        novatela.setLocationRelativeTo(null);
    }
}

