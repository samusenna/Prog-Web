public class Professor extends FuncionarioBonificado{
    private Integer qtdAulasSemana;
    private Double valorHoraAula;
    public Professor(String nome, String funcao, Integer qtdAulasSemana, Double valorHoraAula) {
        super(nome, funcao);
        this.qtdAulasSemana = qtdAulasSemana;
        this.valorHoraAula = valorHoraAula;

    }

    @Override
    public Double getCalcularSalario() {
        Double salario = 0.0;
        salario = qtdAulasSemana * valorHoraAula * 4.5 * 0.15;
        return salario;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qtdAulasSemana=" + qtdAulasSemana +
                ", valorHoraAula=" + valorHoraAula +
                "} " + super.toString();
    }
}
