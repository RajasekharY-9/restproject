package com.iny.restproject.api;

import com.iny.restproject.dto.UserRequestDTO;
import com.iny.restproject.entity.User;
import com.iny.restproject.repo.UserService;
import com.iny.restproject.repo.UserValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserRequestDTO request) {
        try {
            userService.addUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
        } catch (UserValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        try {
            UserRequestDTO user = userService.getUser(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (UserValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    List<User> findAll(){
        return userService.getAllUsersWithDirections();
    }
}
