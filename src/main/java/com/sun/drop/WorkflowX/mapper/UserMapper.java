package com.sun.drop.WorkflowX.mapper;

import com.sun.drop.WorkflowX.dto.UserResponseDto;
import com.sun.drop.WorkflowX.entities.User;

public class UserMapper {
    public static UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        userResponseDto.setRole(user.getRole());
        return userResponseDto;
    }
}
