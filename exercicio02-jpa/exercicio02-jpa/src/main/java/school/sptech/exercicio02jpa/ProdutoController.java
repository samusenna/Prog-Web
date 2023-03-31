package school.sptech.exercicio02jpa;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping()
    public ResponseEntity<Produto> criar(@RequestBody Produto novoProduto){

        if(novoProduto.getNome().length() > 2 && novoProduto.getPrecoUnitario() >= 0.01 &&
                                            novoProduto.getQuantidadeEstoque() >= 1){
            novoProduto.setValorEmEstoque(novoProduto.getQuantidadeEstoque() * novoProduto.getPrecoUnitario());
            Produto produtoBanco = produtoRepository.save(novoProduto);
            return ResponseEntity.status(201).body(produtoBanco);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> litar() {

        List<Produto> produto = produtoRepository.findAll();

        if (produto.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarPorIndice(@PathVariable Long id) {

        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            return ResponseEntity.status(200).body(produtoOpt.get());
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

}
