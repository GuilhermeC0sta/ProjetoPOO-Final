public class admin extends conta {

    public admin(String email, String senha, String nome, int id) {
        super(email, senha, nome, id);
    }

    public String plano;
    public int limitelivro = 0;

    @Override
    public void defPlano(String planoesc) {
        this.plano = planoesc;
    }

    @Override
    public String getPlano() {
        return this.plano;
    }

    @Override
    public int getLimlivro() {
        return this.limitelivro;
    }

}