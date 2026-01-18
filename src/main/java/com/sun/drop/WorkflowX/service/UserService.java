package com.sun.drop.WorkflowX.service;

import com.sun.drop.WorkflowX.dto.CreateUserRequestDto;
import com.sun.drop.WorkflowX.dto.UserResponseDto;
import com.sun.drop.WorkflowX.entities.User;
import com.sun.drop.WorkflowX.mapper.UserMapper;
import com.sun.drop.WorkflowX.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
        private final UserRepository userRepository;
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
        // Get All Users
        @Transactional(readOnly = true)
        public List<UserResponseDto> getAllUsers() {
            return this.userRepository.findAll().stream().map(UserMapper::toDto).toList();
        }
        // Create user
        public UserResponseDto createUser(CreateUserRequestDto userDto) {
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setRole(userDto.getRole());
            User newUser = this.userRepository.save(user);
            return UserMapper.toDto(newUser);
        }
        // Get user By Id
        @Transactional(readOnly = true)
        public UserResponseDto getUserById(Long id) {
            User user = this.userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            return UserMapper.toDto(user);
        }
}