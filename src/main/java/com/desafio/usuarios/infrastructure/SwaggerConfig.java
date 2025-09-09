package com.desafio.usuarios.infrastructure;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Argos System API")
                        .version("1.0")
                        .description("API Para Gestão de Ocorrências Escolares")
                        .contact(new Contact()
                                .name("Arthur")
                                .email("arthurMoura090@gmail.com")
                                .url("https://www.linkedin.com/in/arthur-alves-de-moura")))
                .components(new Components());

    }
}
