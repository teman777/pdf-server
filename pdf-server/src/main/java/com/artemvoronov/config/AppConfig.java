package com.artemvoronov.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.fasterxml.jackson.databind.Module;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
@ComponentScan(value={"com.artemvoronov"})
@EnableWebMvc
public class AppConfig {

  

}
