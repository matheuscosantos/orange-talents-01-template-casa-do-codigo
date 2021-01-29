package br.com.zup.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
// Carga intrínseca 3
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Size(max = 400)
    private String descricao;

//    1
    @ManyToOne(cascade = CascadeType.ALL)
    private DadosPessoais dadosPessoais;

    @NotNull
    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }
//     1
    public Autor(@NotBlank @Size(max = 400)String descricao, DadosPessoais dadosPessoais) {
//     1
        if(descricao==null || descricao.trim().equals("") || descricao.length() > 400){
            throw new IllegalArgumentException("A descrição é obrigatória e deve ter menos de 400 caracteres.");
        }
        this.descricao = descricao;
        this.dadosPessoais = dadosPessoais;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
}
