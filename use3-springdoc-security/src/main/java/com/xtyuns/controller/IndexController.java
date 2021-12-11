package com.xtyuns.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "springdoc & security")
@SecuritySchemes({
        @SecurityScheme(
                name = "byBearer",
                type = SecuritySchemeType.HTTP,
                scheme = "bearer"
        ),
        @SecurityScheme(
                name = "byApiKey",
                type = SecuritySchemeType.APIKEY,
                in = SecuritySchemeIn.HEADER,
                paramName = "customerKey"
        ),
        @SecurityScheme(
                name = "byOAuth2",
                type = SecuritySchemeType.OAUTH2,
                flows = @OAuthFlows(
                        authorizationCode = @OAuthFlow(
                                authorizationUrl = "http://example.com/oauth2/authorize",
                                tokenUrl = "http://example.com/oauth2/token",
                                scopes = {
                                        @OAuthScope(name = "userInfo", description = "获取用户身份信息")
                                }
                        ),
                        password = @OAuthFlow(
                                tokenUrl = "http://example.com/oauth2/token"
                        )
                )

        )
})
public class IndexController {

    @Operation(
            summary = "这是默认请求地址",
            security = {
                    @SecurityRequirement(name = "byOAuth2")
            },
            responses = {
                @ApiResponse(responseCode = "200", description = "请求成功, 响应: ok"),
                @ApiResponse(responseCode = "500", description = "服务器内部出错了")
            }
    )
    @GetMapping("")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("ok");
    }
}