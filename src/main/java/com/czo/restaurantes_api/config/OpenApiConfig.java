package com.czo.restaurantes_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Restaurantes API",
                version = "v1",
                contact = @Contact(
                        name = "Bruno Miranda",
                        email = "bruno.sergio.165@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
