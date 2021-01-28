package br.com.zup.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Carga intrínseca 2
//    1
public interface AutorRepository extends JpaRepository<Autor, Long> {
//    1
    Optional<Autor> findByDadosPessoaisEmail(String email);
}
