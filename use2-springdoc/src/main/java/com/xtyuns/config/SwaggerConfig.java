package com.xtyuns.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

//    // 不分组的接口文档
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .info(apiInfo());
//    }

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("Swagger - SpringDoc")
                .packagesToScan("com.xtyuns.controller")
                .addOpenApiCustomiser(openApi -> openApi.info(apiInfo()))
                .build();
    }

    private Info apiInfo() {
        return new Info()
                .title("SpringDoc 文档")
                .contact(new Contact().name("XTvLi").url("https://github.com/xtyuns"))
                .description("这是 SpringDoc 的文档描述信息")
                .version("1.0.0");
    }

}
