package com.ddev.userservice.mappers;

import com.ddev.userservice.dtos.UserRequest;
import com.ddev.userservice.dtos.UserResponse;
import com.ddev.userservice.models.User;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public User toModel(UserRequest dto) {
        return User
                .builder()
                .name(dto.name())
                .login(dto.login())
                .password(dto.password())
                .build();
    }

    public UserResponse toDto(User model) {
        return new UserResponse(model.getId(), model.getName(), model.getLogin());
    }

}
