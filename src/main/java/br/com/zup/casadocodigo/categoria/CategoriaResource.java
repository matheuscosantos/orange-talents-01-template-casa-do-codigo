package br.com.zup.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
// Carga intrínseca 4
public class CategoriaResource {

//    1
    @Autowired
    CategoriaRepository categoriaRepository;

//    1
    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid CategoriaForm categoriaForm){
//        1
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaForm.getNome());
//        1
        if(possivelCategoria.isEmpty()){
            categoriaRepository.save(categoriaForm.toModel());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
