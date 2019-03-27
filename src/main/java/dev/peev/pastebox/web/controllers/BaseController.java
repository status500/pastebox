package dev.peev.pastebox.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
  protected ModelAndView view(final String viewName, final ModelAndView modelAndView) {
    modelAndView.setViewName(viewName);
    return modelAndView;
  }

  protected ModelAndView view(final String viewName) {
    return view(viewName, new ModelAndView());
  }
}
