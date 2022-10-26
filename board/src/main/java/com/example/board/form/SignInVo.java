package com.example.board.form;


public class SignInVo {
    private String userId;
    private String pwd;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public SignInVo(String userId, String pwd, String userName) {
        this.userId = userId;
        this.pwd = pwd;
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }
}
