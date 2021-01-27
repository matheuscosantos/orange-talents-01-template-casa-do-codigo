package br.com.zup.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class DadosPessoais {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String nome;

    public DadosPessoais() {
    }

    public DadosPessoais(@Email @NotBlank String email, @NotBlank String nome) {

        if(email==null || email.trim().equals("")){
            throw new IllegalArgumentException("O email é obrigatório.");
        }

        if(nome==null || nome.trim().equals("")){
            throw new IllegalArgumentException("O nome é obrigatório.");
        }

        this.email = email;
        this.nome = nome;
    }

}
