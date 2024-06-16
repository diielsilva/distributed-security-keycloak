package com.ddev.userservice.dtos;

public record UserResponse(
        Integer id,
        String name,
        String login
) {
}
