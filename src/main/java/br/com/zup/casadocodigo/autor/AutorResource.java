package br.com.zup.casadocodigo.autor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorResource {

    AutorRepository autorRepository;

    AutorResource(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public Autor cria(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.toModel();
        return autorRepository.save(autor);
    }
}
