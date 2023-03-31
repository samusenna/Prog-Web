package school.sptech.exerciciovalendonota01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> listHerois = new ArrayList<>();

    @GetMapping
    public List listar() {
        return listHerois;
    }

    @GetMapping("/{indice}")
    public Heroi buscarPorIndice(@PathVariable Integer indice) {
        if (indice <= listHerois.size() && indice >= 0) {

            return listHerois.get(indice);
        }
            return null;
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public String cadastrarHeroi(@PathVariable String nome, @PathVariable String habilidade,
    @PathVariable Integer idade, @PathVariable Double forca, @PathVariable Boolean vivo){
      if(nome != null && habilidade != null && idade != null && forca != null && vivo != null){
        Heroi heroi = new Heroi(nome, idade, habilidade, forca, vivo);

        listHerois.add(heroi);

        return "Heroi: " + nome + " cadastrado com sucesso!";
      }
      return "Cadastro de heroi inconsistente. falha ao preencher algum campo!!";
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public String atualizarHeroi(@PathVariable Integer indice, @PathVariable String nome, @PathVariable String habilidade,
    @PathVariable Integer idade, @PathVariable Double forca, @PathVariable Boolean vivo){
        if(nome != null && habilidade != null && idade != null && forca != null && vivo != null) {
            Heroi heroi = new Heroi(nome, idade, habilidade, forca, vivo);

            listHerois.set(indice, heroi);

            return "Herói atualizado com Sucesso";
        }
        return "Informações incompletas, autualização não efetuada!";
    }

    @GetMapping("/remover/{indice}")
public String removerHeroi(@PathVariable Integer indice){

        if(indice >= 0 && indice < listHerois.size()){
            for(int i = 0; i < listHerois.size(); i++){
                if(indice == i) {
                    listHerois.remove(i);

                    return "Heroi: " + indice + " Removido da lista!";
                }
            }
        }

        return "Indice de heroi não encontrado ou invalido!";
    }
}
