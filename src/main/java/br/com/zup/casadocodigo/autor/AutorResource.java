package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autores")
public class AutorResource {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.toModel();

        Optional<Autor> autorOptional = autorRepository.findByDadosPessoaisEmail(autorForm.getEmail());
        if (autorOptional.isEmpty()){
            autorRepository.save(autor);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
