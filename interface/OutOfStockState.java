import javax.swing.JOptionPane;

public class OutOfStockState implements LivroEstado {

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public int rent(int qntd_disp) {
        JOptionPane.showMessageDialog(null,
            "Livro indisponível, tente novamente em outro momento.");
        throw new IllegalStateException("Livro não disponível para aluguel.");
    }
    
    @Override
    public int returnbook(int qntd_disp){
        return qntd_disp + 1;
    }
}
