package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.compartilhado.ExistsId;
import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public Estado toModel(EntityManager em){
        Pais pais = em.find(Pais.class, idPais);
        Assert.state(pais!=null, "Você está tentando cadastrar um país que não existe.");
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
