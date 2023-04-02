package school.sptech.exercicio03validations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exercicio03validations.dominio.Carro;
import school.sptech.exercicio03validations.repository.CarroRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public ResponseEntity<List<Carro>> listar() {
        List<Carro> carros = carroRepository.findAll();

        if (carros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(carros);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody @Valid Carro novoCarro) {
        Carro carroCadastrado = this.carroRepository.save(novoCarro);
        return ResponseEntity.status(201).body(carroCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> listarPorIndice(@PathVariable Long id) {
        Optional<Carro> carroOpt = carroRepository.findById(id);

        if (carroOpt.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return  ResponseEntity.of(carroOpt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
