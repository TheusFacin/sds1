package io.github.theusfacin.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.theusfacin.dspesquisa.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {
  
}
