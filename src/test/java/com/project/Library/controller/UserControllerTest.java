package com.project.Library.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Library.model.User;
import com.project.Library.service.UserService;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false) 
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper; // For converting objects to JSON

    @Test
    public void createUser_ShouldReturnCreatedUser() throws Exception {
        // Given
        User inputUser = new User("Chirine", "EL BADRAOUI", 23, "0625190637");
        User savedUser = new User("Chirine", "EL BADRAOUI", 23, "0625190637");
        savedUser.setId(1L); // Simulate the saved user with ID

        when(userService.createUser(any(User.class))).thenReturn(savedUser);

        // When & Then
        mockMvc.perform(
                post("/api/users") 
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.firstname").value("Chirine"))
                .andExpect(jsonPath("$.lastname").value("EL BADRAOUI"))
                .andExpect(jsonPath("$.age").value(23))
                .andExpect(jsonPath("$.mobile").value("0625190637"));
    }
}
