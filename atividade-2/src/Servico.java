public class Servico implements Vendavel{
    private String descricao;
    private Integer codigo;
    private Integer qtdhora;
    private Double valorHora;

    public Servico(String descricao, Integer codigo, Integer qtdhora, Double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtdhora = qtdhora;
        this.valorHora = valorHora;
    }

    @Override
    public Double getValorVenda() {

        return qtdhora * valorHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQtdhora() {
        return qtdhora;
    }

    public void setQtdhora(Integer qtdhora) {
        this.qtdhora = qtdhora;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return
        String.format("Descrições de serviços prestados \n " +
                        "Descrição de serviço: %s \n" +
                        "codigo do serviço: %d \n" +
                        "Quantidade de horas trabalhadas: %d \n" +
                        "Valor das horas trabalhadas: %.2f \n" +
                super.toString(),
                         descricao,
                          codigo,
                          qtdhora,
                          valorHora);
    }
}
