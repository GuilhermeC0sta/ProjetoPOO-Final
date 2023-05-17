public class Livro extends ItemsBiblioteca {
    private LivroEstado state;
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
        if(qntd_disp > 0){
            state = new AvailableState();
        }
        else{
            state = new OutOfStockState();
        }
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

    private void updateState() {
        if (qntd_disp == 0) {
            state = new OutOfStockState();
        } else {
            state = new AvailableState();
        }
    }

    public void RentLivro() {
        try{
            int qntd_temp = state.rent(qntd_disp);
            this.qntd_disp = qntd_temp;
            updateState();
        }catch(IllegalStateException e){
        }
    }

    public void returnbookLivro() {
        qntd_disp = state.returnbook(qntd_disp);
        updateState();
    }

    public boolean isAvailable() {
        return state.isAvailable();
    }
}
