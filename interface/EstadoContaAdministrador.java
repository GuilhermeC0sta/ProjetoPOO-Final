public class EstadoContaAdministrador extends EstadoConta{

    public EstadoContaAdministrador(LoginRegister.TelaInicial telaInicial){
        super(telaInicial);
    }

    @Override
    public void mostrarTela() {
        telaAdmin novatela = new telaAdmin();
        novatela.setVisible(true);
        novatela.setLocationRelativeTo(null);
    }

}

