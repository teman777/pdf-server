package com.artemvoronov.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(value={"com.artemvoronov"})
@EnableWebMvc
public class AppConfig {

}
