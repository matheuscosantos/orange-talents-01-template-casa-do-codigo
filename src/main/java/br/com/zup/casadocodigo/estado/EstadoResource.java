package br.com.zup.casadocodigo.estado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity cria(@RequestBody @Valid EstadoRequest request){
        Estado estado = request.toModel(em);
        em.persist(estado);
        return ResponseEntity.ok().build();
    }
}
