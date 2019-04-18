package dev.peev.pastebox.commons.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = NOT_FOUND, reason = "Paste was not found!")
public class PasteNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public PasteNotFoundException(String message) {
    super(message);
  }
}
