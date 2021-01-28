package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// Carga intrínseca 2
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String titulo;

    @NotEmpty
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotEmpty
    @Column(unique = true)
    private String isbn;

    @Future
    private LocalDate dataDePublicacao;

//    1
    @NotNull
    @ManyToOne
    private Categoria categoria;

//    1
    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotEmpty String titulo,
                 @NotEmpty @Size(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer numeroDePaginas,
                 @NotEmpty String isbn,
                 @Future LocalDate dataDePublicacao,
                 @NotNull Categoria categoria,
                 @NotNull Autor autor) {

        if(titulo == null || titulo.trim().equals("")){
            throw new IllegalArgumentException("O título é obrigatório.");
        }

        if(resumo == null || resumo.trim().equals("") || resumo.length() > 500){
            throw new IllegalArgumentException("O resumo é obrigatório e deve ter no máximo 500 caracteres.");
        }

        if(preco == null || preco.longValue() < 20){
            throw new IllegalArgumentException("O preço é obrigatório e deve ser no minímo R$20,00");
        }

        if(numeroDePaginas == null || numeroDePaginas < 100){
            throw new IllegalArgumentException("O número de páginas é obrigatório e deve ter no mínimo 100 páginas");
        }

        if(isbn == null || isbn.trim().equals("")){
            throw new IllegalArgumentException("O ISBN é obrigatório");
        }

        if(dataDePublicacao.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("A data de publicação deve ser no futuro");
        }

        if(categoria == null){
            throw new IllegalArgumentException("A categoria não deve ser nula");
        }

        if(autor == null){
            throw new IllegalArgumentException("O autor não deve ser nulo.");
        }
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
