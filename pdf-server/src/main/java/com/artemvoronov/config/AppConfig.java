package com.artemvoronov.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.fasterxml.jackson.databind.Module;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(value={"com.artemvoronov"})
@EnableWebMvc
public class AppConfig {

  @Bean(name="multipartResolver")
  public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(10000000);
    return multipartResolver;
  }



}
