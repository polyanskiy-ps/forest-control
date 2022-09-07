package ru.topaztree.topaztree.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI(@Value("${spring.application.name}") String appTitle) {
        OpenAPI openAPI = new OpenAPI();
        openAPI.setComponents(new Components());
        openAPI
                .info((new Info().title(appTitle)
                        .description(appTitle)
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(
                                new Contact()
                                        .email("pps@topazelectro.ru")
                                        .name("Отдел ПО"))))
                .externalDocs(new ExternalDocumentation()
                        .description("Company-service WiKi Documentation")
                        .url("http://springdoc.org"));

        return openAPI;

    }

}
