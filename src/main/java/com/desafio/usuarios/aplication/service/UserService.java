package com.desafio.usuarios.aplication.service;

import com.desafio.usuarios.aplication.dto.user.UserResponse;
import com.desafio.usuarios.domain.entity.User;
import com.desafio.usuarios.domain.pageable.Pagination;
import com.desafio.usuarios.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse<List<User>> getUsers(
            int page,
            int pageSize,
            String q,  //nome ou email
            String role,
            Boolean isActive,
            Instant createdAfter,
            Instant createdBefore
    ){
        final int max_pageSize = 50;
        if (pageSize > max_pageSize){
            pageSize = max_pageSize;
        }

        Stream<User> stream = userRepository.findAll().stream();

        if(q != null && !q.isBlank()){
            String query = q.toLowerCase();
            stream = stream.filter(u -> u.getName().toLowerCase().contains(query) || u.getEmail().toLowerCase().contains(query));
        }

        if(role != null){
            String query = role.toLowerCase();
            stream =  stream.filter(user -> user.getRole().toLowerCase().contains(query));
        }

        if(isActive != null){
            stream =  stream = stream.filter(user -> user.getIsActive() == isActive);
        }

        if (createdAfter != null){
            stream =  stream = stream.filter(user -> user.getCreatedAt().isAfter(createdAfter));
        }

        if (createdBefore != null){
            stream =  stream = stream.filter(user -> user.getCreatedAt().isBefore(createdBefore));
        }

        List<User> filtered = stream.toList();

        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, filtered.size());

        List<User> paginated = fromIndex >= filtered.size()
                ? List.of()
                : filtered.subList(fromIndex, toIndex);

        return new UserResponse<>(
                paginated,
                new Pagination(page, pageSize, filtered.size())
        );

    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }
}
