package br.com.zup.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    private DadosPessoais dadosPessoais;

    @NotNull
    private LocalDateTime instante = LocalDateTime.now();

    public Autor() {
    }

    public Autor(String descricao, DadosPessoais dadosPessoais) {
        if(descricao==null || descricao.trim().equals("") || descricao.length() > 400){
            throw new IllegalArgumentException("A descrição é obrigatória e deve ter menos de 400 caracteres.");
        }
        this.descricao = descricao;
        this.dadosPessoais = dadosPessoais;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", nome=" + dadosPessoais.getNome() +
                ", email=" + dadosPessoais.getEmail() +
                ", instante=" + instante +
                '}';
    }
}
