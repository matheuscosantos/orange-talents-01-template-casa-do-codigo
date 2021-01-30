package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.compartilhado.CPFouCNPJ;
import br.com.zup.casadocodigo.compartilhado.ExistsId;
import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CPFouCNPJ
    private String cpfOuCnpj;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @NotNull
    @ManyToOne
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

}
