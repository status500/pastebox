package dev.peev.pastebox.service.impl;

import dev.peev.pastebox.domain.entities.Paste;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.repository.PasteRepository;
import dev.peev.pastebox.service.interfaces.LocalDateTimeService;
import dev.peev.pastebox.service.interfaces.PasteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasteServiceImpl implements PasteService {
  private final PasteRepository pasteRepository;
  private final ModelMapper modelMapper;
  private final LocalDateTimeService localDateTimeService;

  @Autowired
  public PasteServiceImpl(
      PasteRepository pasteRepository,
      ModelMapper modelMapper,
      LocalDateTimeService localDateTimeService) {
    this.pasteRepository = pasteRepository;
    this.modelMapper = modelMapper;
    this.localDateTimeService = localDateTimeService;
  }

  @Override
  public PasteServiceModel save(final PasteServiceModel pasteServiceModel) {
    pasteServiceModel.setCreatedOn(localDateTimeService.now());

    return modelMapper.map(
        pasteRepository.save(modelMapper.map(pasteServiceModel, Paste.class)),
        PasteServiceModel.class);
  }

  @Override
  public PasteServiceModel findById(final String id) {
    return modelMapper.map(pasteRepository.findById(id).get(), PasteServiceModel.class);
  }
}
