package io.github.theusfacin.dspesquisa.repositories;

import java.time.Instant;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.theusfacin.dspesquisa.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

  @Query("SELECT obj FROM Record obj WHERE "
        // IS NULL OR faz retornar todos se não existir
        // coalesce() garante que o valor seja aceito no Postgress
        + "(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND "
        + "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
	Page<Record> findByMoments(Instant min, Instant max, Pageable pageable);

}
