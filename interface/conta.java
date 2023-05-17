public abstract class conta {

    private String email, senha, nome, planoesc; // tinha um index user, mas foi removido
    private int id, biostam = 0;

    public conta(String email, String senha, String nome, int id) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void defPlano(String planoesc) {
        this.planoesc = planoesc;
    }

    public String getPlano() {
        return "*DESCARTE*";
    }

    public int getLimlivro() {
        return 1000;
    }

    public String getValormulta() {
        return "*DESCARTE*";
    }

    public String getTempomulta() {
        return "*DESCARTE*";
    }

    public void defBios(String bio) {
    }

    public int getBiotam() {
        return this.biostam;
    }
}