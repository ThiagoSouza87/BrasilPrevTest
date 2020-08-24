package br.com.brasilprev.brasilprevteste.config;

import br.com.brasilprev.brasilprevteste.controller.CustomerController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.brasilprev.brasilprevteste.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Test BrasilPrev API ",
                "API REST customers management",
                "1.0",
                "Terms of Service",
                new Contact(
                        "Thiago Souza",
                        "github.com",
                        "thiago.santos.souza87@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org.licesen.html"
        );
        return apiInfo;
    }
}
