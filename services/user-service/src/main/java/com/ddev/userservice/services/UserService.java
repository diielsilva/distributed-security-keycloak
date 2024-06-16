package com.ddev.userservice.services;

import com.ddev.userservice.dtos.UserRequest;
import com.ddev.userservice.dtos.UserResponse;
import com.ddev.userservice.mappers.ModelMapper;
import com.ddev.userservice.models.User;
import com.ddev.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserResponse create(UserRequest requestBody) {
        User user = modelMapper.toModel(requestBody);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return modelMapper.toDto(user);
    }

}
