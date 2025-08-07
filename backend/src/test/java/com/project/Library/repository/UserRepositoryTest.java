package com.project.Library.repository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.Library.model.User;
import com.project.Library.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldPersistUserWhenSaved() {
        // Given
        User expectedUser = new User("Riad", "BENRADI", 27, "0767334891");

        //When
        User expectedSavedUser = userRepository.save(expectedUser);

       //Then
        assertAll(
                () -> assertNotNull(expectedSavedUser),
                () -> assertEquals("Riad", expectedSavedUser.getFirstname()));
    }

    @Test
    void shouldRetrieveUserByIdWhenExists() {
        // Given
        User expectedUser = new User("Riad", "BENRADI", 27, "0767334891");
        User expectedSavedUser = userRepository.save(expectedUser);

         //When
        Optional<User> foundUser = userRepository.findById(expectedSavedUser.getId());

        //Then
        assertAll(
                () -> assertTrue(foundUser.isPresent()),
                () -> assertEquals("Riad", foundUser.get().getFirstname()));
    }
}
