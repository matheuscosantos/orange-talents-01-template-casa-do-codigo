package br.com.zup.casadocodigo.categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @Column(unique = true)
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
