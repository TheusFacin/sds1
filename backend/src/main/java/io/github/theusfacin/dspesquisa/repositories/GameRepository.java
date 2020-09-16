package io.github.theusfacin.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.theusfacin.dspesquisa.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
  
}
