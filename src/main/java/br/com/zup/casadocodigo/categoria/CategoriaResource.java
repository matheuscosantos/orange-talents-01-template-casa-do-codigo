package br.com.zup.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    CategoriaRepository categoriaRepository;

    @Autowired
    private ProibeNomeDuplicadoValidator proibeNomeDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeDuplicadoValidator);
    }

    public CategoriaResource(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid CategoriaForm categoriaForm){
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaForm.getNome());
        if(possivelCategoria.isEmpty()){
            categoriaRepository.save(categoriaForm.toModel());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
