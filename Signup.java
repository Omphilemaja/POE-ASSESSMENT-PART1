/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.util.Scanner;

public class Signup {

    private String storedUsername;
    private String storedPassword;

    public String registerUser(String username, String password, String phone) {

        if (!checkUsername(username)) {
            return "Username is not correctly formatted (min 5 characters).";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password must be at least 8 characters long.";
        }

        if (!checkCellphoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or missing +27.";
        }

        storedUsername = username;
        storedPassword = password;

        return "Registration successful!";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    public boolean checkCellphoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() >= 12;
    }

    public boolean checkUsername(String username) {
        return username.length() >= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8;
    }

       
}

