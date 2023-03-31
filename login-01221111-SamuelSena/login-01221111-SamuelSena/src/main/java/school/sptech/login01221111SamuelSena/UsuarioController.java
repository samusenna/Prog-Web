package school.sptech.login01221111SamuelSena;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController(List<Usuario> usuarios) {
        this.usuarios = new ArrayList<>();
    }

    @GetMapping
    public List<UserSeg> listar(){
        List<UserSeg> listSeg = usuarios.stream().map(user -> new UserSeg(user))
                .collect(Collectors.toList());
        return listSeg;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario novoUsuario){
        usuarios.add(novoUsuario);

        return novoUsuario;
    }

    @PostMapping("/{usuario}/{senha}")
    public Usuario autenticacao (@PathVariable String usuario, @PathVariable String senha){
        for(Usuario a: usuarios) {
            if (a.getUsuario().equals(usuario) && a.getSenha().equals(senha)) {
                a.setAutenticado(true);

                return a;

            }
        }

        return null;
    }

    @DeleteMapping("/{usuario}")
    public String delete (@PathVariable String usuario){
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getUsuario().equals(usuario) && usuarios.get(i).getAutenticado().equals(true)){
                usuarios.get(i).setAutenticado(false);
                return "Logoff do usuário " + usuarios.get(i).getNome() + " concluído!!";

            } else if (usuarios.get(i).getUsuario().equals(usuario) && usuarios.get(i).getAutenticado().equals(false) ){
                return "Usuário " + usuarios.get(i).getNome() + " NÃO está autenticado";

            } else {
                return "Usuário " + usuarios.get(i).getUsuario() + " não encontrado";

            }
        }
        return "Erro ao passar o usuario";
    }


    // O método criado é um método o qual permite o usuário a alterar o seu cadastro,
    // mudando os parâmetros no Json.
    // Só é possível o usuário alterar o seu cadastro se ele estiver autenticado.
    @PutMapping("/{indice}")
    public String editarCadastro (@PathVariable int indice, @RequestBody Usuario editCadastro){
            if (indice >= 0 && indice < usuarios.size()) {
                if (usuarios.get(indice).getAutenticado().equals(true)) {
                    usuarios.set(indice, editCadastro);
                    return "Cadastro de usuário alterado com sucesso!!";

                }else{

                    return "Para efetuar a alteração de cadastro seu login você deve estar autenticado";
                }
            }

        return "Cadastro não alterado";

    }
}
