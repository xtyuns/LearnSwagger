package com.xtyuns.controller;

import com.xtyuns.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("springdoc")
@Tag(name = "首页")
public class IndexController {

    @Operation(summary = "这是默认请求地址")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "请求成功, 响应: ok"),
            @ApiResponse(responseCode = "500", description = "服务器内部出错了")
    })
    @GetMapping("")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("ok");
    }

    @Operation(summary = "计算两个数字的和")
    @Parameters({
            @Parameter(name = "num1", description = "第一个数字", required = true),
            @Parameter(name = "num2", description = "第二个数字", example = "0")
    })
    @ApiResponse(responseCode = "200", description = "返回指定数字之和")
    @GetMapping("sum")
    public ResponseEntity<Integer> getSum(Integer num1,@RequestParam(defaultValue = "0") Integer num2) {
        return ResponseEntity.ok(num1 + num2);
    }

    @Operation(summary = "添加一个用户")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "用户信息" , required = true)
    @ApiResponse(responseCode = "200", description = "返回所保存用户的详细信息")
    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}