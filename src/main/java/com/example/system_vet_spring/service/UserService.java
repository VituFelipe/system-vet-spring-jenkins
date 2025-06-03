package com.example.system_vet_spring.service;

import com.example.system_vet_spring.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }

    public List<User> listUsers() {
        return users;
    }

    public Optional<User> findById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
