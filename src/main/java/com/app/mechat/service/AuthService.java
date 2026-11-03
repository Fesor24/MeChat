package com.app.mechat.service;

import com.app.mechat.Dto.LoginRequestDto;
import com.app.mechat.Dto.RegisterUserRequestDto;

public interface AuthService {
    String register(RegisterUserRequestDto request);
    String login(LoginRequestDto request);
}
