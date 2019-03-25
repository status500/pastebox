package dev.peev.pastebox.domain.entities;

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
}
