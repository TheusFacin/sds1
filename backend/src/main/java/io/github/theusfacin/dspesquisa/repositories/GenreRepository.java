package io.github.theusfacin.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.theusfacin.dspesquisa.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
  
}
