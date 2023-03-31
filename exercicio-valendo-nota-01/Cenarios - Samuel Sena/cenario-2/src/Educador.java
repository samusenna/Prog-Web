public abstract class Educador {
    private String nome;
    private String funcao;

    public Educador(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public Double getValorBonus(){
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Educador{" +
                "nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
