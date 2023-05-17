import java.util.*;
public class apoio_livros extends utensilios {

    private int slots;

    public apoio_livros(String marca, int slots, int quantidade) {
        super(marca, quantidade);
        this.slots = slots;
    }
    

    public int getSlots() {
        return slots;
    }
    
    @Override
    public ArrayList<String> getInformacao(){
        ArrayList<String> getInformacao = new ArrayList<>();
        getInformacao.add("Tipo: Apoio de Livros");
        getInformacao.add("Marca: " + this.getMarca());
        getInformacao.add("Slots: " + this.getSlots());
        getInformacao.add("Quantidade: " + this.getQuantidade());
        return getInformacao;
    }
}
