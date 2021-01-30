package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
// Carga intrínseca 9
public class Endereco {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
//        1
    private Pais pais;

    @NotNull
    @ManyToOne
//        1
    private Estado estado;
//        2
    public Endereco(@NotBlank String endereco,
                    @NotBlank String complemento,
                    @NotBlank String cidade,
                    @NotNull Pais pais,
                    @NotNull Estado estado) {
//        1
        if(endereco == null || endereco.trim().equals("")){
            throw new IllegalArgumentException("O endereço é obrigatório.");
//            1
        }else if(complemento == null || complemento.trim().equals("")){
            throw new IllegalArgumentException("O complemento é obrigatório.");
//            1
        }else if(cidade == null || cidade.trim().equals("")){
            throw new IllegalArgumentException("A cidade é obrigatória.");
//            1
        }else if(pais == null){
            throw new IllegalArgumentException("O país é obrigatório.");
//            1
        }else if(estado == null) {
            throw new IllegalArgumentException("O estado é obrigatório.");
        }
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
    }

}
