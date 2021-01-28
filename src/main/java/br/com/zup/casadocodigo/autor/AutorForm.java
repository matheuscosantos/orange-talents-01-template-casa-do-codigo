package br.com.zup.casadocodigo.autor;

import br.com.zup.casadocodigo.categoria.Categoria;
import br.com.zup.casadocodigo.compartilhado.UniqueValue;

import javax.annotation.Resource;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Resource
// Carga intrínseca 2
public class AutorForm {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = DadosPessoais.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

//  1
    public Autor toModel(){
//  1
        return new Autor(this.descricao, new DadosPessoais(this.email, this.nome));
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
