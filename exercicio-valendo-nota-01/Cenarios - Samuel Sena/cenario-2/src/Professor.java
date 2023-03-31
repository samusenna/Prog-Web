public class Professor extends Educador{
    private Integer qtdAulasSemana;
    private Double valorAula;
    public Professor(String nome, String funcao, Integer qtdAulasSemana, Double valorAula) {
        super(nome, funcao);
        this.qtdAulasSemana = qtdAulasSemana;
        this.valorAula = valorAula;

    }


    public Double getValorBonus(){
        Double bonus = 0.0;
        bonus = qtdAulasSemana * valorAula * 4.5 * 0.15;
        return bonus;
    }

    public Double getCalcularSalario() {

        return qtdAulasSemana * valorAula;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qtdAulasSemana=" + qtdAulasSemana +
                ", valorAula=" + valorAula +
                "} " + super.toString();
    }
}
