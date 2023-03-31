package school.sptech.atividade1sprint2;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    List<Filme> filme = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Filme>> listarJogos(){
        if(filme.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filme);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Filme> listar(@PathVariable int indice){
        if(indice > 0 && indice <= filme.size()){
            return ResponseEntity.status(200).body(filme.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar (@RequestBody Filme novoFilme){

        if(novoFilme.getNome().length() > 2 && novoFilme.getAnoLancamento() > 1895){
            filme.add(novoFilme);

        }
        return ResponseEntity.status(201).body(novoFilme);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable int indice, @RequestBody Filme atlFilme){
        if(indice > 0 && indice <= filme.size()){
            filme.set(indice, atlFilme);

            return ResponseEntity.status(200).body(atlFilme) ;
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/{indice}/oscars")
    public ResponseEntity<FilmeDto> atualizarOscar(@PathVariable int indice, @PathVariable int oscar){
        if(indice > 0 && indice <= filme.size()){

            List<FilmeDto> dto = filme.stream().map(numOscar -> new FilmeDto(numOscar))
                    .collect(Collectors.toList());

            if(filme.get(indice).getQtdOscar() != oscar){
                dto.get(indice).setQuantidade(oscar);
                return ResponseEntity.status(200).build();
            }


        }
        return null;
    }

}



