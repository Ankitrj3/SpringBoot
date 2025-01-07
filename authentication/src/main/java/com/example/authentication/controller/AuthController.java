package com.example.authentication.controller;

import com.example.authentication.model.Users;
import com.example.authentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Users user) {
    authService.signup(user.getUsername(), user.getPassword());
    return ResponseEntity.ok("User registered successfully!");
}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
    boolean authenticated = authService.login(user.getUsername(), user.getPassword());
    if (authenticated) {
         return ResponseEntity.ok("Login successful!");
    } else {
        return ResponseEntity.badRequest().body("Invalid username or password");
    }
}

}
