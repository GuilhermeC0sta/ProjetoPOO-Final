import javax.swing.JOptionPane;

public class AvailableState implements LivroEstado {
    @Override
    public boolean isAvailable() {
        return true;
    }
    @Override
    public int rent(int qntd_disp) {
        JOptionPane.showMessageDialog(null, "Parabéns, você conseguiu locar um livro!");
        LoginRegister.id_user.add(LoginRegister.index_user);
        LoginRegister.isbn_locado.add(LocarCommand.codiguin);
        return qntd_disp - 1;
    }
    @Override
    public int returnbook(int qntd_disp){
        return qntd_disp + 1;
    }
}
