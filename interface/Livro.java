public class Livro extends ItemsBiblioteca {

    private String autor;
    private int isbn;
    private String genero;
    private String titulo;

    public Livro(String titulo, String autor, int isbn, int qntd_disp, String genero) {
        super(titulo, qntd_disp);

        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public int getIsbn() {
        return isbn;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String getGenero() {
        return genero;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void locar() {

        System.out.println("\nVocê conseguiu locar um livro! Devolva dentro de 10 dias.\n");
        System.out.println(" Este livro possui as seguintes especificações: ");
        System.out.println(" Título: " + getTitulo());
        System.out.println(" Autor: " + autor);
        System.out.println(" Isbn: " + isbn);
        System.out.println(" Genero: " + genero);
        System.out.println(" Quantidade disponível: " + getQnt_disp() + "\n");
    }
}