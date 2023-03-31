package school.sptech.login01221111SamuelSena;

public class UserSeg {
    private String usuario;
    private String nome;
    private Boolean autenticado;

    public UserSeg() {

    }

    public UserSeg(Usuario usuario) {
        this.usuario = usuario.getUsuario();
        this.nome = usuario.getNome();
        this.autenticado = usuario.getAutenticado();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    @Override
    public String toString() {
        return "UserSeg{" +
                "usuario='" + usuario + '\'' +
                ", nome='" + nome + '\'' +
                ", autenticado=" + autenticado +
                '}';
    }
}
