package com.desafio.usuarios.presentation;


import com.desafio.usuarios.aplication.dto.user.UserResponse;
import com.desafio.usuarios.aplication.service.UserService;
import com.desafio.usuarios.domain.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResponse<List<User>>> getUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name = "page_size", defaultValue = "10") int pageSize,
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String role,
            @RequestParam(name = "is_active", required = false) Boolean isActive,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant createdAfter,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant createdBefore

    ) {

        return ResponseEntity.ok(userService.getUsers(page, pageSize, q, role, isActive, createdAfter, createdBefore));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse<User>> getUser(@PathVariable int id){

        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(
                        new UserResponse<>(user, null)
                ))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new UserResponse<>("Usuário com id " + id + " não encontrado.")) // erro
                );
    }

}