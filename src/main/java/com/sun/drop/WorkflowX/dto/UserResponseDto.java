package com.sun.drop.WorkflowX.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private String role;
    private String email;
}
