public class DVD extends Produto{
    private String nome;
    private String gravadora;

    public DVD(Integer codigo, Double precoDeCusto, String nome, String gravadora ) {
        super(codigo, precoDeCusto);
        this.nome = nome;
        this.gravadora = gravadora;
    }

    @Override
    public Double getValorVenda() {
        double calc = 0.0;
        calc = getPrecoDeCusto() * 0.20;
        return getPrecoDeCusto() + calc;
    }

    @Override
    public String toString() {
        return
        String.format("DVD \n" +
                        "Nome do DVD: %s \n" +
                        "Nome da gravadora do DVD: %s \n"+
                        super.toString(),
                   nome,
                   gravadora);
    }
}
