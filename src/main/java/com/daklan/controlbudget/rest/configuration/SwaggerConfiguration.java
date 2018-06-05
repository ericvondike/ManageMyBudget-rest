package com.daklan.controlbudget.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    //private static final String URL_CONTEXT = "/doc";

    @Bean
    public Docket conf() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.daklan.controlbudget.rest.controllers"))
                .paths(PathSelectors.any())
                .build();
        //.pathMapping(URL_CONTEXT);
    }

    @Bean
    public ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder
                .title("APIs Basket")
                .description("List of the Applications APIs for ManageMyBudget Project")
                .version("0.0.1");

        return builder.build();
    }
}
