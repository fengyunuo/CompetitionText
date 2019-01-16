package com.example.administrator.myapplication.model;

/**
 * Created by Administrator on 2019/1/7.
 */

public class Tb_pwd {
    private String password;

    public Tb_pwd(){
        super();
    }
    public Tb_pwd(String password){
        super();
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
