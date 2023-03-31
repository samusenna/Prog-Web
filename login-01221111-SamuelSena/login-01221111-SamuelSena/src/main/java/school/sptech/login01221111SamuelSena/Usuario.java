package school.sptech.login01221111SamuelSena;

public class Usuario {
    private String usuario;
    private String senha;
    private String nome;
    private Boolean autenticado;

    public Usuario() {

    }

    public Usuario(String usuario, String senha, String nome, Boolean autenticado) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.autenticado = autenticado;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
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
        return String.format("Email de Usuário: %d " +
                        "Senha: %d" +
                        "Nome do Usuario: %d" +
                        "Usuario autenticado: %d",
                usuario,
                senha,
                nome,
                autenticado
        );
    }
}
