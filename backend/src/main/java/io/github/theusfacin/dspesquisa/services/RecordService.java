package io.github.theusfacin.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.theusfacin.dspesquisa.dto.RecordDTO;
import io.github.theusfacin.dspesquisa.dto.RecordInsertDTO;
import io.github.theusfacin.dspesquisa.entities.Game;
import io.github.theusfacin.dspesquisa.entities.Record;
import io.github.theusfacin.dspesquisa.repositories.GameRepository;
import io.github.theusfacin.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {
  
  @Autowired
  private RecordRepository repository;

  @Autowired
  private GameRepository gameRepository;

  @Transactional
  public RecordDTO insert(RecordInsertDTO dto) {

    Record entity = new Record();

    entity.setName(dto.getName());
    entity.setAge(dto.getAge());
    entity.setMoment(Instant.now());

    Game game = gameRepository.getOne(dto.getGameId());
    entity.setGame(game);

    entity = repository.save(entity);

    return new RecordDTO(entity);
  }
}
