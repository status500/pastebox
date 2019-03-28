package dev.peev.pastebox.web.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import dev.peev.pastebox.domain.model.request.PasteRequestModel;
import dev.peev.pastebox.domain.model.response.PasteResponseModel;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.service.interfaces.PasteService;

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
    public PasteResponseModel submitPaste(@RequestBody PasteRequestModel pasteRequestModel) {
        return modelMapper.map(pasteService.save(modelMapper.map(pasteRequestModel, PasteServiceModel.class)),
                PasteResponseModel.class);
    }

    @GetMapping(path = "/api/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public PasteResponseModel fetchPaste(@PathVariable(name = "id") final String id) {
        return modelMapper.map(pasteService.findById(id), PasteResponseModel.class);
    }

    @GetMapping(path = "/{id}")
    public ModelAndView paste(ModelAndView modelAndView) {
        modelAndView.setViewName("pastes");

        return modelAndView;
    }
}
