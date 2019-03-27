package dev.peev.pastebox.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
  @Bean
  public ModelMapper createModelMapper() {
    return new ModelMapper();
  }
}
