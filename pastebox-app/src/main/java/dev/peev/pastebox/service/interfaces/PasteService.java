package dev.peev.pastebox.service.interfaces;

import dev.peev.pastebox.domain.model.service.PasteServiceModel;

public interface PasteService {
  PasteServiceModel save(final PasteServiceModel pasteServiceModel);

  PasteServiceModel findById(final String id);
}
