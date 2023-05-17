public abstract class ItemsBiblioteca {

    private String titulo;
    private String autor;
    private String genero;
    private int qntd_disp;
    private int isbn;

    public ItemsBiblioteca(String titulo, int qntd_disp) {
        this.titulo = titulo;
        this.qntd_disp = qntd_disp;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setQnt_disp(int qntd_disp) {
        this.qntd_disp = qntd_disp;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getQnt_disp() {
        return qntd_disp;
    }

    public abstract void locar();

}