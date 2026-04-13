package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testMainRunsWithoutCrashing() {
        assertDoesNotThrow(() -> Login.main(new String[]{}));
    }
}