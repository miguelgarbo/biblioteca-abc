package com.uni.biblioteca_abc.repository;

import com.uni.biblioteca_abc.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
