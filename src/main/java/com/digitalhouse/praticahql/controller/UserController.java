package com.digitalhouse.praticahql.controller;

import com.digitalhouse.praticahql.dto.request.UserRequest;
import com.digitalhouse.praticahql.dto.response.UserResponse;
import com.digitalhouse.praticahql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        var response = userService.findAllUsers();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/name")
    public ResponseEntity<List<UserResponse>> findByUserNameContains(@RequestParam("name") String name) {
        var response = userService.findByUserNameContains(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
        var response = userService.findUserById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserPassword(@PathVariable Long id, @RequestBody UserRequest request) {
        request.setId(id);
        userService.updateUserPassword(request);
        return ResponseEntity.noContent().build();
    }

}
