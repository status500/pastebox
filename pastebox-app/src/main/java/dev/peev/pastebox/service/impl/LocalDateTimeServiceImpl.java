package dev.peev.pastebox.service.impl;

import dev.peev.pastebox.service.interfaces.LocalDateTimeService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class LocalDateTimeServiceImpl implements LocalDateTimeService {

  @Override
  public LocalDateTime now() {
    return LocalDateTime.now();
  }
}
