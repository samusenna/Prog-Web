public class Gospel extends Musica{
    private Boolean adoracao;
    private Double tempoMusica;

    public Gospel(String nome, String compositor, String gravadora, String cantor, Boolean adoracao, Double tempoMusica) {
        super(nome, compositor, gravadora, cantor);
        this.adoracao = adoracao;
        this.tempoMusica = tempoMusica;
    }


    public void tempoTotalDeMusica (){
        Double tempo = 0.0;
        System.out.println("Tempo toltal de musica :" + (tempo += tempoMusica));
    }


    @Override
    public String toString() {
        return "Gospel{" +
                "adoracao=" + adoracao +
                "} " + super.toString() + "\n";
    }
}
