package com.desafio.usuarios.domain.repository;

import com.desafio.usuarios.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {


    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws IOException {
        userRepository = new UserRepository();
    }

    @Test
    void deveCarregarUsuariosDoJson() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}