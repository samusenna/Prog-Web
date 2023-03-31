package school.sptech.projeto04jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
