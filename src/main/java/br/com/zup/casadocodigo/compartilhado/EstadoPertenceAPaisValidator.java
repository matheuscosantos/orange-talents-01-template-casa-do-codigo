package br.com.zup.casadocodigo.compartilhado;

import br.com.zup.casadocodigo.compra.ClienteRequest;
import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClienteRequest request = (ClienteRequest) target;

        Pais pais = manager.find(Pais.class, request.getIdPais());
        Estado estado = manager.find(Estado.class, request.getIdEstado());


        if(!estado.pertenceAPais(pais)){
            errors.rejectValue("idEstado", null, "este estado não é do país selecionado.");
        }
    }
}
