package dev.peev.pastebox.web.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import dev.peev.pastebox.domain.model.binding.PasteSaveBindingModel;
import dev.peev.pastebox.domain.model.response.PastesResponseModel;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.service.PasteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/paste", consumes = APPLICATION_JSON_UTF8_VALUE)
public class PasteController {
  private final PasteService pasteService;
  private final ModelMapper modelMapper;

  @Autowired
  public PasteController(PasteService pasteService, ModelMapper modelMapper) {
    this.pasteService = pasteService;
    this.modelMapper = modelMapper;
  }

  @PostMapping
  public PastesResponseModel submitPaste(@RequestBody PasteSaveBindingModel pasteSaveBindingModel) {
    return modelMapper.map(
        pasteService.save(modelMapper.map(pasteSaveBindingModel, PasteServiceModel.class)),
        PastesResponseModel.class);
  }

  @GetMapping("/{id}")
  public PastesResponseModel findPaste(@PathVariable(name = "id") final String id) {
    return modelMapper.map(pasteService.findById(id), PastesResponseModel.class);
  }
}
