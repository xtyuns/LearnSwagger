package xtyuns.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        // details in io.swagger.v3.oas.annotations.security.SecurityScheme
                        .addSecuritySchemes("byBearerJwt", new SecurityScheme()
                                .name("Authorization")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                        .addSecuritySchemes("byOAuth2", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(
                                        new OAuthFlows()
                                        .authorizationCode(new OAuthFlow()
                                                .authorizationUrl("https://example.com/oauth2/authoriza")
                                                .tokenUrl("https://example.com/oauth2/authoriza")
                                                .scopes(new Scopes()
                                                        .addString("userInfoScope", "获取用户身份信息")
                                                        .addString("otherScope", "其他详细信息")
                                                )
                                        )
                                )
                        )
                )
                // 将所有请求设置为保护资源
                .addSecurityItem(
                        // details in io.swagger.v3.oas.annotations.security.SecurityRequirement
                        new SecurityRequirement()
                            .addList("byBearerJwt")
                            .addList("byOAuth2", "userInfoScope")
                );
    }
}
