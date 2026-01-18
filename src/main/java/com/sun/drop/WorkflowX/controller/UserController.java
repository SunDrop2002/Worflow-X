package com.sun.drop.WorkflowX.controller;

import com.sun.drop.WorkflowX.dto.CreateAssetRequestDto;
import com.sun.drop.WorkflowX.dto.CreateUserRequestDto;
import com.sun.drop.WorkflowX.dto.UserResponseDto;
import com.sun.drop.WorkflowX.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get All users
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = this.userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid CreateUserRequestDto createUserRequestDto) {
        UserResponseDto userCreated = this.userService.createUser(createUserRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto user = this.userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

}
