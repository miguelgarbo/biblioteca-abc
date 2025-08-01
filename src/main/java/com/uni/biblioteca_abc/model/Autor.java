package com.uni.biblioteca_abc.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity

public class Autor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;

    @ManyToMany
    @JoinTable(name = "autor_livro")
    private List<Livro> livros;



}
