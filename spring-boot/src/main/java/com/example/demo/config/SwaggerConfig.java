package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Spring Boot").apiInfo(apiInfo()).select()
                .paths(regex("/employee.*")).build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Employe Service")
                .description("Sample Documentation Generated Using SWAGGER2 for our Employee Rest API")
                .termsOfServiceUrl("https://google.com")
                .license("java license")
                .licenseUrl("https://google.com").version("1.0").build();
    }
}
