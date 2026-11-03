package com.app.mechat.controller;

import com.app.mechat.Dto.LoginRequestDto;
import com.app.mechat.Dto.RegisterUserRequestDto;
import com.app.mechat.service.AuthService;
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
    public String login(@RequestBody LoginRequestDto request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterUserRequestDto request){
        return authService.register(request);
    }
}
