package school.sptech.buscadoresdinamicos.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.buscadoresdinamicos.Repository.FilmeRepository;
import school.sptech.buscadoresdinamicos.domain.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public ResponseEntity<List<Filme>> listar (){

        List<Filme> filmes = filmeRepository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody @Valid Filme novoFilme) {
        Filme filmeCadastrado = filmeRepository.save(novoFilme);
        return ResponseEntity.status(201).body(filmeCadastrado);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Filme> listarPorIndice (@PathVariable Long id){

      //  return ResponseEntity.of(this.filmeRepository.findById(id));
        Optional<Filme> filmesFiltrados =
                this.filmeRepository.findById(id);

//        Optional <Filme> filmeOpt = filmeRepository.findById(id);
//
       if (filmesFiltrados.isEmpty()) {
           return ResponseEntity.status(404).build();
       }
        return  ResponseEntity.of(filmesFiltrados);
    }

    @GetMapping("/titulo")
    public ResponseEntity<Optional<Filme>>listarPorNome (@RequestParam String nome){


        Optional<Filme>  filmesFiltrados =
                this.filmeRepository.findByNome(nome);

//       List<Filme> filmes = this.filmeRepository.findAll();
//
//        Optional<Filme> filmeProcurado = filmes.stream()
//                .filter(filme -> filme.getNome().equals(nome))
//                .findAny();
//
//
//
        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
       return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/diretor")
    public ResponseEntity<List<Filme>> listarPorDiretor (@RequestParam String nome){

        List<Filme>  filmesFiltrados =
                this.filmeRepository.findByDiretorIgnoreCase(nome);

//        List<Filme> filmes = this.filmeRepository.findAll();
//        Optional<Filme> diretorProcurado = filmes.stream()
//                .filter(filme -> filme.getDiretor().equals(nome))
//                .findAny();
//
        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();

        }
        return ResponseEntity.status(200).body(filmesFiltrados);

    }

    @GetMapping("/data")
    public ResponseEntity<List<Filme>> listarPorData (@RequestParam LocalDate data){
        List<Filme> filmes = this.filmeRepository.findAll();

        List<Filme> filmesFiltrado =
                this.filmeRepository.findByDataLancamentoLessThanEqual(data);

//        Optional<Filme> diretorProcurado = filmes.stream()
//                .filter()
//                .findAny();

        if (filmesFiltrado.isEmpty()) {
            return ResponseEntity.status(204).build();

        }
        return ResponseEntity.status(200).body(filmesFiltrado);

    }

    @GetMapping("/indicados")
    public ResponseEntity<List<Filme>> buscarSomenteIndicados (){
        List<Filme> filmesFiltrado =
                this.filmeRepository.findByIndicacaoOscarTrue();

//        List<Filme> filmes = this.filmeRepository.findAll();


//        Optional<Filme> diretorProcurado = filmes.stream()
//                .filter()
//                .findAny();

        if (filmesFiltrado.isEmpty()) {
            return ResponseEntity.status(204).build();

        }
        return ResponseEntity.status(200).body(filmesFiltrado);

    }

    @GetMapping("/nao-indicados/quantidade")
    public ResponseEntity<Integer> buscarquantidadeDeNaoIndicados (){
//        List<Filme> filmes = this.filmeRepository.findAll();


//        Optional<Filme> diretorProcurado = filmes.stream()
//                .filter()
//                .findAny();

            int contador = this.filmeRepository.countByIndicacaoOscarFalse();
            return ResponseEntity.status(200).body(contador);

    }

    @GetMapping("/custo-producao/{custo}")
    public ResponseEntity<List<Filme>> buscarFilmesComCustoAlto ( @PathVariable double custo){
        List<Filme> filmesFiltrado =
                this.filmeRepository.findByCustoProducaoGreaterThanEqual(custo);

//        List<Filme> filmes = this.filmeRepository.findAll();


//        Optional<Filme> diretorProcurado = filmes.stream()
//                .filter()
//                .findAny();

        if (filmesFiltrado.isEmpty()) {
            return ResponseEntity.status(204).build();

        }
        return ResponseEntity.status(200).body(filmesFiltrado);

    }
}
