public class audiobook extends ItemsBiblioteca {
    private LivroEstado state;
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
    public String getTitulo() {
        return titulo;
    }

    public int getAudio() {
        return id_audio;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public int getQnt_disp() {
        return qntd_disp;
    }

    private void updateState() {
        if (qntd_disp == 0) {
            state = new OutOfStockState();
        } else {
            state = new AvailableState();
        }
    }

    public void rent() {
        if (state.isAvailable()) {
            this.qntd_disp--;
            updateState();
        } else {
            throw new IllegalStateException("Livro não disponível para aluguel.");
        }
    }

    public void returnbook() {
        this.qntd_disp++;
        updateState();
    }

    public boolean isAvailable() {
        return state.isAvailable();
    }
}
