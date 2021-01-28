package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autores")
// Carga intrínseca 5
public class AutorResource {

    @Autowired
    AutorRepository autorRepository;

//        1
    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid AutorForm autorForm){
//        1
        Autor autor = autorForm.toModel();
//        1
        Optional<Autor> autorOptional = autorRepository.findByDadosPessoaisEmail(autorForm.getEmail());
//        1
        if (autorOptional.isEmpty()){
            autorRepository.save(autor);
            return ResponseEntity.ok().build();
//        1
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
