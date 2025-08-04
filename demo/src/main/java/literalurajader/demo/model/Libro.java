package literalurajader.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore // Ignorar el ID de la API durante la deserialización
    private Long id;
    @Column(unique = true)
    @JsonAlias("title")
    private String titulo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    @JsonAlias("languages")
    private List<String> idiomas;
    @JsonAlias("download_count")
    private Integer numeroDescargas;
    public Libro() {
    }

    public Libro(String titulo, Autor autor, List<String> idiomas, Integer numeroDescargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idiomas = idiomas;
        this.numeroDescargas = numeroDescargas;
    }

    @JsonSetter("authors")
    public void setAuthors(List<Autor> authors) {
        if (authors != null && !authors.isEmpty()) {
            this.autor = authors.get(0);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "------ LIBRO ------" +
               "\nTitulo: " + titulo +
               "\nAutor: " + (autor != null ? autor.getNombre() : "Desconocido") +
               "\nIdioma: " + (idiomas != null && !idiomas.isEmpty() ? idiomas.get(0) : "Desconocido") +
               "\nNúmero de descargas: " + numeroDescargas +
               "\n-------------------";
    }
}

