package dev.peev.pastebox.web.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import dev.peev.pastebox.domain.model.binding.PasteSaveBindingModel;
import dev.peev.pastebox.domain.model.response.PastesResponseModel;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.service.PasteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/pastes")
public class PasteController {
  private final PasteService pasteService;
  private final ModelMapper modelMapper;

  @Autowired
  public PasteController(PasteService pasteService, ModelMapper modelMapper) {
    this.pasteService = pasteService;
    this.modelMapper = modelMapper;
  }

  @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public PastesResponseModel submitPaste(@RequestBody PasteSaveBindingModel pasteSaveBindingModel) {
    return modelMapper.map(
        pasteService.save(modelMapper.map(pasteSaveBindingModel, PasteServiceModel.class)),
        PastesResponseModel.class);
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public PastesResponseModel pasteJson(@PathVariable(name = "id") final String id) {
    return modelMapper.map(pasteService.findById(id), PastesResponseModel.class);
  }

  @GetMapping
  public ModelAndView paste(ModelAndView modelAndView) {
    modelAndView.setViewName("get");

    return modelAndView;
  }
}
