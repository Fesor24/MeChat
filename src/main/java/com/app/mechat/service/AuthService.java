package com.app.mechat.service;

import com.app.mechat.dto.LoginRequestDto;
import com.app.mechat.dto.RegisterUserRequestDto;
import com.app.mechat.primitives.Result;

public interface AuthService {
    Result<String> register(RegisterUserRequestDto request);
    Result<String> login(LoginRequestDto request);
}
