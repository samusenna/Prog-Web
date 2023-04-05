package school.sptech.buscadoresdinamicos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.buscadoresdinamicos.domain.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository <Filme, Long> {

    Optional<Filme> findByNome(String nome);
    List<Filme> findByDiretorIgnoreCase(String nome);
    List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);
    List<Filme> findByIndicacaoOscarTrue();
    int countByIndicacaoOscarFalse();
    List<Filme> findByCustoProducaoGreaterThanEqual(double custo);
}
