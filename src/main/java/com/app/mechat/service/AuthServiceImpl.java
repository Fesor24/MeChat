package com.app.mechat.service;

import com.app.mechat.Dto.LoginRequestDto;
import com.app.mechat.Dto.RegisterUserRequestDto;
import com.app.mechat.entity.User;
import com.app.mechat.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String register(RegisterUserRequestDto request) {

        boolean userWithEmailExist = userRepository.existsByEmail(request.email());

        if(userWithEmailExist)
            throw new RuntimeException("User with email exists");

        boolean userWithUserNameExist = userRepository.existsByUserName(request.userName());

        if(userWithUserNameExist)
            throw new RuntimeException("User with username exists");

        User newUser = User.create(
                request.firstName(),
                request.lastName(),
                request.userName(),
                request.email(),
                request.password()
        );

        userRepository.save(newUser);

        return "access-token";
    }

    @Override
    public String login(LoginRequestDto request) {
        User user = userRepository.findByUserName(request.userName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return "access-token";
    }
}
