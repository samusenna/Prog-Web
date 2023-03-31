public class Coordenador extends Educador {
    private Integer qtdHorasCoord;
    private Double valorHoraCoord;

    public Coordenador(String nome, String funcao) {
        super(nome, funcao);
        this.qtdHorasCoord = qtdHorasCoord;
        this.valorHoraCoord = valorHoraCoord;

    }

    @Override
    public Double getValorBonus(){
        Double bonus = 0.0;
        bonus = qtdHorasCoord * valorHoraCoord * 4.5 * 0.2;
        return bonus;
    }

    public Double getCalculaSalario(){

        return qtdHorasCoord * valorHoraCoord;
    }


    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHorasCoord=" + qtdHorasCoord +
                ", valorHoraCoord=" + valorHoraCoord +
                "} " + super.toString();
    }
}
