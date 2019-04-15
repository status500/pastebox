package dev.peev.pastebox.domain.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pastes")
@Getter
@Setter
@NoArgsConstructor
public class Paste extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", columnDefinition = "text")
  private String content;

  @Column(name = "syntax")
  private String syntax = "text";

  @Column(name = "created_on", nullable = false, updatable = false)
  private LocalDateTime createdOn;
}
