import java.util.ArrayList;

public class marca_texto extends utensilios {

    private String cor;
    private String brilho;

    public marca_texto(String marca, String cor, String brilho, int quantidade) {
        super(marca, quantidade);
        this.cor = cor;
        this.brilho = brilho;
    }

    public String getCor() {
        return cor;
    }

    public String getBrilho() {
        return brilho;
    }

    @Override
    public ArrayList<String> getInformacao(){
        ArrayList<String> getInformacao = new ArrayList<>();
        getInformacao.add("Tipo: Marca Texto");
        getInformacao.add("Marca: " + this.getMarca());
        getInformacao.add("Cor: " + this.getCor());
        getInformacao.add("Brilho: " + this.getBrilho());
        getInformacao.add("Quantidade: " + this.getQuantidade());
        return getInformacao;
    }

}
