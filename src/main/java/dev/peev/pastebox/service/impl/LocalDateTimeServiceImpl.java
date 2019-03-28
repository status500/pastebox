package dev.peev.pastebox.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import dev.peev.pastebox.service.interfaces.LocalDateTimeService;

@Service
public class LocalDateTimeServiceImpl implements LocalDateTimeService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
