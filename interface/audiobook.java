public class audiobook extends ItemsBiblioteca {

    private String autor;
    private int duracao;
    private String genero;
    private int id_audio;
    private String titulo;
    private int qntd_disp;

    public audiobook(String titulo, String autor, int duracao, int qnt_disp, String genero, int id_audio) {
        super(titulo, qnt_disp);

        this.titulo = titulo;
        this.duracao = duracao;
        this.autor = autor;
        this.genero = genero;
        this.id_audio = id_audio;
        this.qntd_disp = qnt_disp;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public int getAudio() {
        return id_audio;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public int getQnt_disp() {
        return qntd_disp;
    }

    @Override
    public void locar() {
        System.out.println("\nVocê conseguiu locar um livro! Devolva dentro de 10 dias.\n");
        System.out.println(" Este livro possui as seguintes especificações: ");
        System.out.println(" Título: " + getTitulo()); // qlqr coisa usa o this
        System.out.println(" Autor: " + autor);
        System.out.println(" duracao: " + duracao);
        System.out.println(" Genero: " + genero);
        System.out.println(" Quantidade disponível: " + getQnt_disp() + "\n");
    }

}
