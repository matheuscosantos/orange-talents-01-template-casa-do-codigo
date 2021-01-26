package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AutorForm request = (AutorForm) target;
        Optional<Autor> possivelAutor = autorRepository.findByDadosPessoaisEmail(request.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "Já existe um(a) outro(a) autor(a) com o mesmo email "
                                + request.getEmail());
        }
    }
}
