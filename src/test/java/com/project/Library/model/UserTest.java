package com.project.Library.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;


public class UserTest {
    @Test
    public void shouldCreateUserWithAllAttributes(){

        //Given
        Long expectedId = 1L;
        String expectedFirstname = "Riad";
        String expectedLastname = "BENRADI";
        int expectedAge = 27;
        String expectedMobile = "0767334891";
        
        //When
        User user = new User(expectedFirstname,expectedLastname,expectedAge,expectedMobile);

        //Then
        assertAll(
            () -> assertEquals(expectedFirstname, user.getFirstname()),
            () -> assertEquals(expectedLastname, user.getLastname()),
            () -> assertEquals(expectedMobile, user.getMobile()),
            () -> assertEquals(expectedAge, user.getAge()),
            () -> assertNotNull(user.getLoans())
        );

    }
}
