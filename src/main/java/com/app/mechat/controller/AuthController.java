package com.app.mechat.controller;

import com.app.mechat.dto.LoginRequestDto;
import com.app.mechat.dto.RegisterUserRequestDto;
import com.app.mechat.primitives.Result;
import com.app.mechat.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Result<String>> login(@Valid @RequestBody LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Result<String>> register(@Valid @RequestBody RegisterUserRequestDto request){
        return ResponseEntity.ok(authService.register(request));
    }
}
