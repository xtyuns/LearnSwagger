package com.xtyuns.controller;

import com.xtyuns.domain.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("springfox")
@Api(tags = "首页")
public class IndexController {

    @ApiOperation(value = "这是默认请求地址")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功, 响应: ok"),
            @ApiResponse(code = 500, message = "服务器内部出错了")
    })
    @GetMapping("")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("ok");
    }

    @ApiOperation(value = "计算两个数字的和")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num1", value = "第一个数字", required = true),
            @ApiImplicitParam(name = "num2", value = "第二个数字", defaultValue = "0")
    })
    @ApiResponse(code = 200, message = "返回指定数字之和")
    @GetMapping("sum")
    public ResponseEntity<Integer> getSum(Integer num1,@RequestParam(defaultValue = "0") Integer num2) {
        return ResponseEntity.ok(num1 + num2);
    }

    @ApiOperation(value = "添加一个用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true)
    @ApiResponse(code = 200, message = "返回所保存用户的详细信息")
    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
