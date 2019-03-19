package dev.peev.pastebox.domain.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasteSaveBindingModel {
    private String title;
    private String content;
}
