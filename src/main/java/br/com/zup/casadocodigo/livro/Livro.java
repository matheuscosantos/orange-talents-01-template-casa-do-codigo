package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// Carga intrínseca 12
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
//  2
    public Livro(@NotEmpty String titulo,
                 @NotEmpty @Size(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer numeroDePaginas,
                 @NotEmpty String isbn,
                 @Future LocalDate dataDePublicacao,
                 @NotNull Categoria categoria,
                 @NotNull Autor autor) {
//  1
        if(titulo == null || titulo.trim().equals("")){
            throw new IllegalArgumentException("O título é obrigatório.");
        }
//  1
        if(resumo == null || resumo.trim().equals("") || resumo.length() > 500){
            throw new IllegalArgumentException("O resumo é obrigatório e deve ter no máximo 500 caracteres.");
        }
//  1
        if(preco == null || preco.longValue() < 20){
            throw new IllegalArgumentException("O preço é obrigatório e deve ser no minímo R$20,00");
        }
//  1
        if(numeroDePaginas == null || numeroDePaginas < 100){
            throw new IllegalArgumentException("O número de páginas é obrigatório e deve ter no mínimo 100 páginas");
        }
//  1
        if(isbn == null || isbn.trim().equals("")){
            throw new IllegalArgumentException("O ISBN é obrigatório");
        }
//  1
        if(dataDePublicacao.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("A data de publicação deve ser no futuro");
        }
//  1
        if(categoria == null){
            throw new IllegalArgumentException("A categoria não deve ser nula");
        }
//  1
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
