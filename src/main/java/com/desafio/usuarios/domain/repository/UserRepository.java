package com.desafio.usuarios.domain.repository;

import com.desafio.usuarios.domain.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users;


    public UserRepository() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        InputStream input = getClass().getResourceAsStream("/mock-users.json");
        users = Arrays.asList(mapper.readValue(input, User[].class));
    }


    public List<User> findAll(){
        return users;
    }

    public Optional<User> findById(int id){
        var user =  users.stream().filter(u -> u.getId() == id);

        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

}
