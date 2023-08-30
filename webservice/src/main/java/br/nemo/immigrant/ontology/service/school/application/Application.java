package br.nemo.immigrant.ontology.service.school.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.nemo.immigrant.ontology.service.school.*"})
@EntityScan(basePackages = {"br.nemo.immigrant.ontology.entity.school.*"})
@EnableJpaRepositories(basePackages = {"br.nemo.immigrant.ontology.service.school.*"})
@OpenAPIDefinition(info = @Info(
  title = "school",
  version = "1.0",
  description = "A Webservice about school"))

public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
