package com.xtyuns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("Swagger - SpringFox")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xtyuns.controller"))
                .build()
                .globalResponses(HttpMethod.GET,
                        Stream.of(
                                new ResponseBuilder()
                                        .code(String.valueOf(HttpStatus.OK.value()))
                                        .description(HttpStatus.OK.getReasonPhrase())
                                        .build(),
                                new ResponseBuilder()
                                        .code(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
                                        .description(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                                        .build()
                        ).collect(Collectors.toList())
                )
                .apiInfo(apiInfo())
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringFox文档")
                .contact(new Contact("XTvLi", "https://github.com/xtyuns", null))
                .description("这是文档描述信息")
                .version("v1.0.0")
                .build();
    }
}
