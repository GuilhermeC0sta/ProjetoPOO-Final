import java.util.*;

public class postit extends utensilios {

    private String cor;

    public postit(String marca, String cor, int quantidade) {
        super(marca, quantidade);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public ArrayList<String> getInformacao() {
        ArrayList<String> getInformacao = new ArrayList<>();
        getInformacao.add("Tipo: Postit");
        getInformacao.add("Marca: " + this.getMarca());
        getInformacao.add("Cor: " + this.getCor());
        getInformacao.add("Quantidade: " + this.getQuantidade());
        return getInformacao;
    }
}
