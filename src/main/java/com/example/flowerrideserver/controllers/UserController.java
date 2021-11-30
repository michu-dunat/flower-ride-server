package com.example.flowerrideserver.controllers;

import com.example.flowerrideserver.models.User;
import com.example.flowerrideserver.models.WarehouseState;
import com.example.flowerrideserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-user")
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return new ResponseEntity<>(406, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(200, HttpStatus.OK);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable(value = "id") int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(200, HttpStatus.OK);
    }

    @PutMapping("/update-user")
    public ResponseEntity<Integer> updateUser(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return new ResponseEntity<>(406, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(200, HttpStatus.OK);
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestBody User credentials) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findByLogin(credentials.getLogin());
        if (user != null) {
            if (user.getPassword().equals(credentials.getPassword())) {
                response.put("loggedIn", "true");
                response.put("role", user.getRole());
            } else {
                response.put("loggedIn", "false");
            }
        }
        return response;
    }
}
