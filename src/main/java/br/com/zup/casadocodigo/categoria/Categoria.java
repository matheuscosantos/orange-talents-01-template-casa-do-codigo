package br.com.zup.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        if(nome==null || nome.trim().equals("")){
            throw new IllegalArgumentException("O nome da categoria deve ser preenchido.");
        }
        this.nome = nome;
    }
}
