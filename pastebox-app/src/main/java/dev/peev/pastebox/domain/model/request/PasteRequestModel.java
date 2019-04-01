package dev.peev.pastebox.domain.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasteRequestModel {
  private String title;
  private String content;
}
