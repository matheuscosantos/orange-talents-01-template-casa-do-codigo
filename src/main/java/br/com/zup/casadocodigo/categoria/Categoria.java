package br.com.zup.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
//      Carga cognitiva 2
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
//        1
        if(nome==null || nome.trim().equals("")){
//        1
            throw new IllegalArgumentException("O nome da categoria deve ser preenchido.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
