package br.com.zup.casadocodigo.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class DadosPessoais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

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

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
