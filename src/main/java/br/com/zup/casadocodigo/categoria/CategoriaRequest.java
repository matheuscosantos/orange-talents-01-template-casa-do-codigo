package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

//      Carga cognitiva 3
public class CategoriaRequest {

//    1
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

//    1
    public Categoria toModel() {
//    1
        return new Categoria(this.nome);
    }
}
