package com.darsa.empservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    public static final Contact SUPPORTED_CONTACTS = new Contact("Darsa", "https://darsatest.netlify.com", "support@mail.com");

    @Bean
    public Docket newApi() {
        Set<String> produce = new HashSet<>(Arrays.asList("application/json", "application/xml"));
        Set<String> consume = new HashSet<>(Arrays.asList("application/json", "application/xml"));

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(produce)
                .consumes(consume);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
                .description("Employee Service with Swagger documentation")
                .termsOfServiceUrl("https://darsatest.netlify.com")
                .license("Employee License v1.0")
                .licenseUrl("https://darsatest.netlify.com")
                .version("3.0")
                .contact(SUPPORTED_CONTACTS)
                .build();
    }
}
