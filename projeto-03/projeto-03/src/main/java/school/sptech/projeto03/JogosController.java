package school.sptech.projeto03;

import org.apache.coyote.Response;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogosController {

    List<Jogo> biblioteca = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos(){
        if(biblioteca.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(biblioteca);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Jogo> buscarPorIndice (@PathVariable int indice){
        if(indice > 0 && indice <= biblioteca.size()){

            return ResponseEntity.status(200).body(biblioteca.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Jogo> criarJogo (@RequestBody Jogo novoJogo){
        biblioteca.add(novoJogo);

        return ResponseEntity.status(201).body(novoJogo);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletarPorIndice (@PathVariable int indice){
        if(indice > 0 && indice <= biblioteca.size()){
            biblioteca.remove(indice);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();

    }

    @PutMapping("/{indice}")
    public ResponseEntity<Jogo> atualizarPorIndice(@PathVariable int indice, @RequestBody Jogo newJogo){
        if(indice > 0 && indice <= biblioteca.size()) {

            biblioteca.set(indice, newJogo);

            return ResponseEntity.status(200).body(newJogo) ;
        }
        return ResponseEntity.status(404).build();
    }

}
