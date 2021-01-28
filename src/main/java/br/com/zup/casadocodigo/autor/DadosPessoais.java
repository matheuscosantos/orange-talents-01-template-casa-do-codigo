package br.com.zup.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
// Carga intrínseca 2
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

    @Deprecated
    public DadosPessoais() {
    }

    public DadosPessoais(@Email @NotBlank String email, @NotBlank String nome) {

//      1
        if(email==null || email.trim().equals("")){
            throw new IllegalArgumentException("O email é obrigatório.");
        }
//      1
        if(nome==null || nome.trim().equals("")){
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        this.email = email;
        this.nome = nome;
    }

}
