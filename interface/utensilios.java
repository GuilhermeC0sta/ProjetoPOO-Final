import java.util.ArrayList;

public abstract class utensilios {
    private String marca;
    private int quantidade;

    public utensilios(String marca, int quantidade) {
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public abstract ArrayList<String> getInformacao();

}
