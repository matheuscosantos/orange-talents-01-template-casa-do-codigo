package br.com.zup.casadocodigo.livro;

import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
// Carga intrínseca 4

public class LivroResponse {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private String dataDePublicacao;
    private String categoria;
    private String autor;

//    1
    public LivroResponse(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.categoria = livro.getCategoria().getNome();
        this.autor = livro.getAutor().getDadosPessoais().getNome();
    }

//    3
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

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataDePublicacao() {
        return dataDePublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }
}
