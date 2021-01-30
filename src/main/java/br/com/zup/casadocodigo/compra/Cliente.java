package br.com.zup.casadocodigo.compra;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
// Carga intrínseca 9
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String cpfOuCnpj;

//    1
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Deprecated
    public Cliente() {
    }
//  1
    public Cliente(@NotBlank @Email String email,
                   @NotBlank String nome,
                   @NotBlank String sobrenome,
                   @NotBlank String cpfOuCnpj,
                   @NotNull Endereco endereco,
                   @NotBlank String telefone,
                   @NotBlank String cep) {
//            1
        if(email == null || email.trim().equals("")){
            throw new IllegalArgumentException("O título é obrigatório.");
//            1
        }else if(nome == null || nome.trim().equals("")){
            throw new IllegalArgumentException("O nome é obrigatório.");
//            1
        }else if(sobrenome == null || nome.trim().equals("")){
            throw new IllegalArgumentException("O sobrenome é obrigatório.");
//            1
        }else if(cpfOuCnpj == null || nome.trim().equals("")){
            throw new IllegalArgumentException("O CPF/CNPJ é obrigatório.");
//            1
        }else if(endereco == null){
            throw new IllegalArgumentException("O endereço é obrigatório.");
//            1
        }else if(telefone == null || nome.trim().equals("")){
            throw new IllegalArgumentException("O nome é obrigatório.");
//            1
        }else if(cep == null || nome.trim().equals("")){
            throw new IllegalArgumentException("O telefone é obrigatório.");
        }
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
    }

}
