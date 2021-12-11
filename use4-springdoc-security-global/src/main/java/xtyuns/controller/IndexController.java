package xtyuns.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "springdoc & security")
public class IndexController {

    @Operation(
            summary = "这是默认请求地址",
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