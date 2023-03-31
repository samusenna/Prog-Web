package school.sptech.projeto04jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/*
  O Repositório (Repository) é quem de fato acessará o banco de dados.

  Na imensa maioria, das vezes teremos 1 repositório para 1 entidade;

  1 Repositório pode devolver um objeto diferente do especificado entre <>

  Sempre vamos estender JpaRepository, pois essa interface contempla os métodos mais utilizados
  quando o assunto é acesso a dados, exemplo:
  - findAll() para buscar todas as ocorrências da tabela;
  - findById() para buscar uma ocorrência ou registro em específico;
  - deleteById() para remover um registro através do id (PK);
  - save() que serve tanto para inserir quanto para atualizar, a lógica que ele faz é simples:
    - caso o objeto (Jogo) tenha id definido, ou seja, id não for nulo, ele irá atualizar o registro em questão;
    - caso o objeto (Jogo) não possua id definido, ele irá inserir na tabela;
*/
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
