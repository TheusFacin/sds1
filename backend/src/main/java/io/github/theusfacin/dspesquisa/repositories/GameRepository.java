package io.github.theusfacin.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.theusfacin.dspesquisa.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
  
}
