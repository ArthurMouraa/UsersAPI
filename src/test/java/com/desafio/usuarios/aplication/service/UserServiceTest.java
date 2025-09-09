package com.desafio.usuarios.aplication.service;

import com.desafio.usuarios.domain.entity.User;
import com.desafio.usuarios.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarUsuárioPorId() {
        Instant date = Instant.parse("2024-05-26T17:11:48Z");
        User mockUser = new User(1, "Arthur", "arthur@email.com","manager", true, date);
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));

        Optional<User> user = userService.getUserById(1);

        assertTrue(user.isPresent());
        assertEquals(1, user.get().getId());
    }
}