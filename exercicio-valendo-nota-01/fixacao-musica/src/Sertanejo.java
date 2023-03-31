public class Sertanejo extends Musica{
    private Boolean sofrencia;

    private Double tempoMusica;

    public Sertanejo(String nome, String compositor, String gravadora, String cantor, Boolean sofrencia, Double tempoMusica) {
        super(nome, compositor, gravadora, cantor);
        this.sofrencia = sofrencia;
        this.tempoMusica = tempoMusica;
    }

    @Override
    public void tempoTotalDeMusica (){
        Double tempo = 0.0;
        System.out.println("Tempo toltal de musica :" + (tempo += tempoMusica));

    }

    @Override
    public String toString() {
        return "Sertanejo{" +
                "sofrencia=" + sofrencia +
                "} " + super.toString() + "\n";
    }
}
