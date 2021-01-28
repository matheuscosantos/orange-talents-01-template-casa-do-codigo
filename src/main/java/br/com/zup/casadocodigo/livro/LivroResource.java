package br.com.zup.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

// Carga intrínseca 5
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
//    1
    public ResponseEntity cria(@RequestBody @Valid LivroForm livroForm){
//    1
        Livro livro = livroForm.toModel(em);
        em.persist(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
//    1
    public Page<LivroResponse> listaTodos(Pageable paginacao){
//        1
        Page<Livro> livros;
//        1
        Page<Livro> livrosEncontrados = livroRepository.findAll(paginacao);
//        1
        return LivroResponse.converter(livrosEncontrados);
    }
}

