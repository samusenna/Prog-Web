public abstract class Produto implements Vendavel {
    private Integer codigo;
    private Double precoDeCusto;

    public Produto(Integer codigo, Double precoDeCusto) {
        this.codigo = codigo;
        this.precoDeCusto = precoDeCusto;
    }

    public Integer getCodigo() {

        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(Double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    @Override
    public String toString() {
        return
        String.format("Codigo do produto: %d \n" +
                        "preço de custo do produto: %.2f \n",

                    codigo,
                    precoDeCusto);
    }
}
