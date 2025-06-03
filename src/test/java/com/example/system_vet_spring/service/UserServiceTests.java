package com.example.system_vet_spring.service;


import com.example.system_vet_spring.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    void testCreateUser() {
        User user = new User(null, "testuser", "test@example.com");
        User created = userService.createUser(user);
        assertNotNull(created.getId());
        assertEquals("testuser", created.getUsername());
    }

    @Test
    void testListUsers() {
        User user = new User(null, "testuser", "test@example.com");
        userService.createUser(user);
        assertEquals(1, userService.listUsers().size());
        assertEquals("testuser", userService.listUsers().get(0).getUsername());
    }
}