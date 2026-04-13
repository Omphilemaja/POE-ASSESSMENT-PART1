package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {

    @Test
    public void testRegisterUser_Success() {
        Signup s = new Signup();
        String result = s.registerUser("user1", "password1", "+27123456789");

        assertEquals("Registration successful!", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        Signup s = new Signup();
        String result = s.registerUser("usr", "password1", "+27123456789");

        assertEquals("Username is not correctly formatted (min 5 characters).", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        Signup s = new Signup();
        String result = s.registerUser("user1", "pass", "+27123456789");

        assertEquals("Password must be at least 8 characters long.", result);
    }

    @Test
    public void testRegisterUser_InvalidPhone() {
        Signup s = new Signup();
        String result = s.registerUser("user1", "password1", "0821234567");

        assertEquals("Cell phone number incorrectly formatted or missing +27.", result);
    }

    @Test
    public void testLoginUser_Correct() {
        Signup s = new Signup();
        s.registerUser("user1", "password1", "+27123456789");

        assertTrue(s.loginUser("user1", "password1"));
    }

    @Test
    public void testLoginUser_WrongPassword() {
        Signup s = new Signup();
        s.registerUser("user1", "password1", "+27123456789");

        assertFalse(s.loginUser("user1", "wrong"));
    }

    @Test
    public void testLoginUser_WrongUsername() {
        Signup s = new Signup();
        s.registerUser("user1", "password1", "+27123456789");

        assertFalse(s.loginUser("wrong", "password1"));
    }

    @Test
    public void testCheckUsername() {
        Signup s = new Signup();

        assertTrue(s.checkUsername("user1"));
        assertFalse(s.checkUsername("usr"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        Signup s = new Signup();

        assertTrue(s.checkPasswordComplexity("password1"));
        assertFalse(s.checkPasswordComplexity("pass"));
    }

    @Test
    public void testCheckCellphoneNumber() {
        Signup s = new Signup();

        assertTrue(s.checkCellphoneNumber("+27123456789"));
        assertFalse(s.checkCellphoneNumber("0821234567"));
    }
}