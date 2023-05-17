interface LivroEstado {
    public abstract boolean isAvailable();
    public abstract int rent(int qntd_disp);
    public abstract int returnbook(int qntd_disp);
}
