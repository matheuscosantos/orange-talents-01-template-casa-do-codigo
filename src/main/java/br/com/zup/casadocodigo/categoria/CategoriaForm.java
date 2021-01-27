package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.compartilhado.UniqueValue;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
