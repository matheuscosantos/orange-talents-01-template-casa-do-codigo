package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
