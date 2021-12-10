package com.xtyuns.domain;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户实体")
public class User {
    @Schema(title = "姓名")
    private String name;
    @Schema(title = "年龄")
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
