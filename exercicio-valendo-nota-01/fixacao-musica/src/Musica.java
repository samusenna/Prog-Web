public abstract class Musica {
    private String nome;
    private String compositor;
    private String gravadora;
    private String cantor;

    public Musica(String nome, String compositor, String gravadora, String cantor) {
        this.nome = nome;
        this.compositor = compositor;
        this.gravadora = gravadora;
        this.cantor = cantor;
    }

    public void tempoTotalDeMusica (){
    }

    public String getNome() {
        return nome;
    }

    public String getCompositor() {
        return compositor;
    }

    public String getGravadora() {
        return gravadora;
    }

    public String getCantor() {
        return cantor;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nome='" + nome + '\'' +
                ", compositor='" + compositor + '\'' +
                ", gravadora='" + gravadora + '\'' +
                ", cantor='" + cantor + '\'' +
                '}';
    }
}
