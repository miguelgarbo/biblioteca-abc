package com.uni.biblioteca_abc.repository;

import com.uni.biblioteca_abc.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
