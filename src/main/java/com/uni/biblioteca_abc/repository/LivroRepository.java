package com.uni.biblioteca_abc.repository;

import com.uni.biblioteca_abc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
