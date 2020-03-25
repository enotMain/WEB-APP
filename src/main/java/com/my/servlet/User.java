package com.my.servlet;

import java.io.Serializable;

/**
 * Класс пользователя
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String login;
    private String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    public User(int id, String login, String password){

        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String u_login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String u_password) {
        this.password = password;
    }
}
