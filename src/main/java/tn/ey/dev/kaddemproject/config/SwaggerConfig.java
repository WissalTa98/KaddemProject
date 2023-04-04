package tn.ey.dev.kaddemproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("Kaddem")
                .description("Projet")
                .contact(contactAPI());

    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Wissal")
                .email("wissal.talbi@esprit.tn")
                .url("https://www.linkedin.com/in/wissal-talbi-4ab821202/");
        return contact;
    }
}
