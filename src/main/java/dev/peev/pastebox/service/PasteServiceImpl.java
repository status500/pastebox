package dev.peev.pastebox.service;

import dev.peev.pastebox.domain.entities.Paste;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.repository.PasteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasteServiceImpl implements PasteService {
  private final PasteRepository pasteRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public PasteServiceImpl(PasteRepository pasteRepository, ModelMapper modelMapper) {
    this.pasteRepository = pasteRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void save(PasteServiceModel pasteServiceModel) {
    pasteRepository.save(modelMapper.map(pasteServiceModel, Paste.class));
  }
}
