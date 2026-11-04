package com.app.mechat.service;

import com.app.mechat.dto.LoginRequestDto;
import com.app.mechat.dto.RegisterUserRequestDto;
import com.app.mechat.entity.User;
import com.app.mechat.exceptions.ConflictException;
import com.app.mechat.exceptions.NotFoundException;
import com.app.mechat.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.app.mechat.primitives.Result;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Result<String> register(RegisterUserRequestDto request) {

        boolean userWithEmailExist = userRepository.existsByEmail(request.email());

        if(userWithEmailExist)
            throw new ConflictException("User with email exists");

        boolean userWithUserNameExist = userRepository.existsByUserName(request.userName());

        if(userWithUserNameExist)
            throw new ConflictException("User with username exists");

        User newUser = User.create(
                request.firstName(),
                request.lastName(),
                request.userName(),
                request.email(),
                request.password()
        );

        userRepository.save(newUser);

        return new Result<>("access-token");
    }

    @Override
    public Result<String> login(LoginRequestDto request) {
        User user = userRepository.findByUserName(request.userName())
                .orElseThrow(() -> new NotFoundException("User or password incorrect"));

        return new Result<>("access-token");
    }
}
