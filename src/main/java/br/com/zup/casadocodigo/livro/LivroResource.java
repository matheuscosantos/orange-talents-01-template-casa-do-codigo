package br.com.zup.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

// Carga intrínseca 2
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
//    1
    public ResponseEntity cria(@RequestBody @Valid LivroForm livroForm){
//    1
        Livro livro = livroForm.toModel(em);
        em.persist(livro);
        return ResponseEntity.ok().build();
    }
}
