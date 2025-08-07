package com.project.Library.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.Library.exceptions.InvalidUserException;
import com.project.Library.model.User;
import com.project.Library.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser_shouldReturnSavedUser_whenValidInput() {

        // Given
        User expectedUser = new User("Riad", "BENRADI", 27, "0767334891");
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);

        // When
        User createdUser = userService.createUser(expectedUser);

        // Then
        assertAll(
                () -> assertEquals("Riad", createdUser.getFirstname()),
                () -> assertEquals("BENRADI", createdUser.getLastname()),
                () -> assertEquals(27, createdUser.getAge()));

    }

    @Test
    void createBook_shouldThrowException_whenFirstnameOrLastnameIsBlank() {
        User invalidUser = new User("", "", 27, "0767334891");
        assertThrows(InvalidUserException.class, () -> userService.createUser(invalidUser));
    }

}
