package br.com.zup.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object targer, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        CategoriaForm request = (CategoriaForm) targer;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());

        if(possivelCategoria.isPresent()){
            errors.rejectValue("nome", null, "Já exites categoria com o nome " + request.getNome());
        }
    }
}
