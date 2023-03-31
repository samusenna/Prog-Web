package school.sptech.primeiraapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private List<String> pokemon = new ArrayList<>();

    @RequestMapping
    public int inicio(){
        return pokemon.size();
    }

    @GetMapping("/cadastrar/{nomePokemon}")
    public String cadastrar(@PathVariable String nomePokemon){
    pokemon.add(nomePokemon);
        return "Pokemon " + nomePokemon + " cadastrado na lista de Pokemon";
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperarPorIndice(@PathVariable Integer indice){
        String nome = "";
        for (int i = 0; i < pokemon.size(); i++){

            if(indice == i){
                nome = pokemon.get(i);
            } else{
                nome = "Esse indice de Pokemon não encontrado na lista!!";
            }
        }
        return nome;
    }

    @GetMapping("/excluir/{indice}")
    public String excluirPorIndice(@PathVariable Integer indice){

        String nome = "";
        for(int i = 0; i < pokemon.size(); i++){
            if(indice == i){
                pokemon.remove(i);
               nome = "Pokemon excluido com sucesso!";
            } else{
                nome = "Esse Pokemon não existe ou já foi excluido!";
            }
        }

            return nome;
    }

    @GetMapping("/atualizar/{indice}/{novoNomePokemon}")
    public String atualizarPokemon(@PathVariable Integer indice, @PathVariable String novoNomePokemon){
        for(int i = 0; i < pokemon.size(); i++){
            if(i == indice){
                pokemon.set(indice, novoNomePokemon);
                return "Pokemon atualizado";
            }
        }
            return "Pokemon não encontrado!";
    }

}
