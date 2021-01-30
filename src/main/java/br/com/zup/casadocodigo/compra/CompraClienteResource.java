package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.compartilhado.EstadoPertenceAPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cliente/compra")
// Carga intrínseca 3
public class CompraClienteResource {

//    1
    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

//    1
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertenceAPaisValidator);
    }

//    1
    @PostMapping
    public ClienteRequest solicitaCompra(@RequestBody @Valid ClienteRequest request){
        return request;
    }
}
