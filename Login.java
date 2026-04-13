package com.mycompany.login;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Signup signup = new Signup();

        System.out.println("=== REGISTER ===");

        System.out.print("Enter First Name: ");
        String firstname = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastname = input.nextLine();

        // USERNAME LOOP
        String username;
        while (true) {
            System.out.print("Enter Username: ");
            username = input.nextLine();

            if (signup.checkUsername(username)) {
                break;
            } else {
                System.out.println("Invalid username. Must be at least 5 characters.");
            }
        }

        // PASSWORD LOOP
        String password;
        while (true) {
            System.out.print("Enter Password: ");
            password = input.nextLine();

            if (signup.checkPasswordComplexity(password)) {
                break;
            } else {
                System.out.println("Invalid password. Must be at least 8 characters.");
            }
        }

        // PHONE LOOP
        String phone;
        while (true) {
            System.out.print("Enter Phone Number (+27...): ");
            phone = input.nextLine();

            if (signup.checkCellphoneNumber(phone)) {
                break;
            } else {
                System.out.println("Invalid phone number. Must start with +27 and be at least 12 digits.");
            }
        }

        // Register user
        String result = signup.registerUser(username, password, phone);
        System.out.println(result);

        // LOGIN
        System.out.println("\n=== LOGIN ===");

        boolean loggedIn = false;
        int attempts = 3;

        while (attempts > 0 && !loggedIn) {

            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            loggedIn = signup.loginUser(loginUser, loginPass);

            if (loggedIn) {
                System.out.println("Login successful! Welcome " + firstname);
            } else {
                attempts--;
                System.out.println("Incorrect details. Attempts left: " + attempts);
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Access denied.");
        }

        input.close();
    }
}