public class Coordenador extends FuncionarioBonificado {
    private Integer qtdHorasCoord;
    private Double valorHoraCoord;
    public Coordenador(String nome, String funcao, Integer qtdHorasCoord, Double valorHoraCoord) {
        super(nome, funcao);
        this.qtdHorasCoord = qtdHorasCoord;
        this.valorHoraCoord = valorHoraCoord;

    }

    @Override
    public Double getCalcularSalario() {
        Double salario = 0.0;
        salario = qtdHorasCoord * valorHoraCoord * 4.5 * 0.2;
        return salario;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHorasCoord=" + qtdHorasCoord +
                ", valorHoraCoord=" + valorHoraCoord +
                "} " + super.toString();
    }
}