package school.sptech.projeto04jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/*
  Ao declarar uma classe com @Entity estamos informando ao Spring que essa classe
  reflete uma entidade(Tabela) no banco de dados.

  O JPA (Java persistence API) cuidará em trocar os nomes em 'camelCase' para 'snake_case' automaticamente.

  No fim, "1 registro de Jogo" representará "1 instância de Jogo" automaticamente se o mapeamento estiver correto.
*/
@Entity
public class Produto {

  @Id // Identificador -> chave primária em nossa tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de indexação, nesse caso 'auto incremento'
  private Long id;
  private String nome;
  private String fabricante;

  // 2023-08-11
  private LocalDate validade;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(String fabricante) {
    this.fabricante = fabricante;
  }

  public LocalDate getValidade() {
    return validade;
  }

  public void setValidade(LocalDate validade) {
    this.validade = validade;
  }
}
