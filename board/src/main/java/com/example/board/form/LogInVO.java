package com.example.board.form;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class LogInVO {
    @NotBlank
    private String id;

    @NotBlank
    private String pwd;

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public LogInVO(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
}
