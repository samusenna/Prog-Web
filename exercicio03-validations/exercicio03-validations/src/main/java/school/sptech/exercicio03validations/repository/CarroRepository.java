package school.sptech.exercicio03validations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exercicio03validations.dominio.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
