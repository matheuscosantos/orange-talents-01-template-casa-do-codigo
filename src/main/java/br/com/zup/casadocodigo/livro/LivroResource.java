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
import java.util.Optional;

// Carga intrínseca 8
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
    public ResponseEntity cria(@RequestBody @Valid LivroForm livroForm ){
//    1
        Livro livro = livroForm.toModel(em);
        em.persist(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
//    1
    public Page<LivroResponse> detalhaItens(Pageable paginacao){
//        1
        Page<Livro> livrosEncontrados;

        livrosEncontrados = livroRepository.findAll(paginacao);
//        1
        return LivroResponse.converter(livrosEncontrados);

    }

    @GetMapping("/{id}")
//    1
    public ResponseEntity<LivroResponse> detalhaItem(@PathVariable Long id){
//        1
        Optional<Livro> possivelLivro = livroRepository.findById(id);
        if(possivelLivro.isPresent()){
//            1
            return ResponseEntity.ok(new LivroResponse(possivelLivro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}

