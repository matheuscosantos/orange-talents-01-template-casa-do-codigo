package br.com.zup.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Carga intrínseca 3
//    2
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
//    1
    Optional<Categoria> findByNome(String nome);
}
