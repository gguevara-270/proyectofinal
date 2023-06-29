package com.scalab.proyectofinal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Users escalab", version = "1.0", description = "Api Restful tipo CRUD de usuarios."))
public class ProyectofinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectofinalApplication.class, args);
	}

}
