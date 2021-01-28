package br.com.zup.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Carga intrínseca 2
@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Long> {
}
