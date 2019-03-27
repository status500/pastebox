package dev.peev.pastebox.web.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import dev.peev.pastebox.domain.model.binding.PasteSaveBindingModel;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.service.PasteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasteController {
  private final PasteService pasteService;
  private final ModelMapper modelMapper;

  @Autowired
  public PasteController(PasteService pasteService, ModelMapper modelMapper) {
    this.pasteService = pasteService;
    this.modelMapper = modelMapper;
  }

  @PostMapping(path = "/paste", consumes = APPLICATION_JSON_UTF8_VALUE)
  public void paste(@RequestBody PasteSaveBindingModel pasteSaveBindingModel) {
    pasteService.save(modelMapper.map(pasteSaveBindingModel, PasteServiceModel.class));
  }
}
