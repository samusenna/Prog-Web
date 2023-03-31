package school.sptech.projeto04jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    //    private List<Produto> produtos = new ArrayList<>();
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping()
    public ResponseEntity<Produto> criar(@RequestBody Produto novoProduto) {

        //produtos.add(novoProduto);
        Produto produtoBanco = produtoRepository.save(novoProduto);
        return ResponseEntity.status(201).body(produtoBanco);

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
    public ResponseEntity<Produto> listarIndice(@PathVariable Long id) {

        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            return ResponseEntity.status(200).body(produtoOpt.get());
        }

//      return ResponseEntity.of(produtoOpt)
        return ResponseEntity.status(404).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,
                                                    @RequestBody Produto atualizaProduto){

        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoRepository.existsById(id)) {
            atualizaProduto.setId(id);
            produtoRepository.save(atualizaProduto);
            return ResponseEntity.status(200).body(atualizaProduto);
        }


        return ResponseEntity.status(404).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable Long id){

        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
