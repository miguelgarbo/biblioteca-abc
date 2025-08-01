package com.uni.biblioteca_abc.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer numeroPaginas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("livros")
    private Editora editora;

    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;

    @ManyToOne
    private Biblioteca biblioteca; // ✅ Correto agora


}
