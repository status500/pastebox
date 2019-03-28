package dev.peev.pastebox.domain.model.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PasteResponseModel {
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdOn;
}
