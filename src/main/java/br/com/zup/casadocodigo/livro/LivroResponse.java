package br.com.zup.casadocodigo.livro;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {
    private Long id;
    private String titulo;
    private String resumo;
//    private String sumario;
//    private BigDecimal preco;
//    @NotNull @Min(100) Integer numeroDePaginas,
//    @NotEmpty String isbn,
//    @Future LocalDate dataDePublicacao,
//    @NotNull Categoria categoria,
//    @NotNull Autor autor

    public LivroResponse(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
    }

    public static Page<LivroResponse> converter(Page<Livro> livros){
        return livros.map(LivroResponse::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }
}
