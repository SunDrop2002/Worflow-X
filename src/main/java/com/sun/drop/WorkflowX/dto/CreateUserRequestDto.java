package com.sun.drop.WorkflowX.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String role;
    @NotBlank
    private String email;
}
