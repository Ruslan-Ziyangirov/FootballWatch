package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.services.UsersService;
import javax.annotation.security.PermitAll;

import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/api/users")
    @ResponseBody
    public List<User> getUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping(value = "/api/users")
    @ResponseBody
    public User addUser(@RequestBody UserDto user) {
        return usersService.addUser(user);
    }

    @PutMapping(value = "/api/users/{id_user}")
    @ResponseBody
    public User updateUser(@PathVariable("id_user") Long userId, @RequestBody UserDto user) {
        return usersService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/api/users/{id_user}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable("id_user") Long userId) {
        usersService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
