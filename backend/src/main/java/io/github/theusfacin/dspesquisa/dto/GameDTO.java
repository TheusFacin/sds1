package io.github.theusfacin.dspesquisa.dto;

import java.io.Serializable;

import io.github.theusfacin.dspesquisa.entities.Game;
import io.github.theusfacin.dspesquisa.entities.enums.Platform;

public class GameDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private Long id;
  private String title;
  private Platform platform;

  public GameDTO() {
  }

  public GameDTO(Game entity) {
    id = entity.getId();
    title = entity.getTitle();
    platform = entity.getPlatform();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Platform getPlatform() {
    return this.platform;
  }

  public void setPlatform(Platform platform) {
    this.platform = platform;
  }

}
