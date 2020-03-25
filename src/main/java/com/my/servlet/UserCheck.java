package com.my.servlet;

import java.util.ArrayList;

/**
 * Поиск пользователя в листе
 */
public class UserCheck {
    public static boolean isUserCorrect(ArrayList<User> users, String login, String password){
        for (User user: users){
            if (user.getLogin().equals(login)){
                if(user.getPassword().equals(password)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
