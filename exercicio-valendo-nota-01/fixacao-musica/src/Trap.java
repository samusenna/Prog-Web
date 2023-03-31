public class Trap extends Musica {

    private Boolean dis;
    private Double tempTrack;
    public Trap(String nome, String compositor, String gravadora, String cantor, Boolean dis, Double tempTrack) {
        super(nome, compositor, gravadora, cantor);
        this.dis = dis;
        this.tempTrack = tempTrack;
    }

    @Override
    public void tempoTotalDeMusica (){
        Double tempo = 0.0;


    }


    @Override
    public String toString() {
        return "Trap{" +
                "dis=" + dis +
                "} " + super.toString() + "\n";
    }
}
