package com.uni.biblioteca_abc.model;
//Entidade BIBLIOTECA com os atributos: id (inteiro), nome (texto) e telefone
//(texto);
//▪ Entidade LIVRO com os atributos: id (inteiro), ISSN (texto), título (texto), sinopse
//(texto), ano (inteiro) e número de páginas (inteiro);
//▪ Entidade AUTOR com os atributos: id (inteiro), nome (texto), cpf (texto) e idade
//(inteiro);
//▪ Entidade EDITORA com os atributos: id (inteiro), nome (texto), endereço (texto)
//e telefone (texto).

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
}
