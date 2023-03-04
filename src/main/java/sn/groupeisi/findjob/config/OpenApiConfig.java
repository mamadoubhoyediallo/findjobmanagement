package sn.groupeisi.findjob.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestion des offres d'emploi")
                        .description("Application de gestion d'offres d'emploi")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Groupe isi")
                                .url("https://groupeisi.com")
                                .email("mbdiallo1isidk@groupeisi.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }
}
