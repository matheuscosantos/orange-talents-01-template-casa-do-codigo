package br.com.zup.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pais")
public class PaisResource {

    @Autowired
    PaisRepository repository;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid PaisRequest request){
        repository.save(request.toModel());
        return ResponseEntity.ok().build();
    }
}
