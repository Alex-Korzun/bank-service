package com.banking.bankservice.controller;

import com.banking.bankservice.mapper.UserMapper;
import com.banking.bankservice.model.User;
import com.banking.bankservice.model.dto.request.UserRequestDto;
import com.banking.bankservice.model.dto.response.UserResponseDto;
import com.banking.bankservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public void create(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.fromDto(userRequestDto);
        userService.save(user);
    }

    @PutMapping("/{userId}")
    public UserResponseDto update(@RequestBody UserRequestDto userRequestDto,
                                  @PathVariable Long userId) {
        User user = userMapper.fromDto(userRequestDto);
        user.setId(userId);
        userService.save(user);
        return userMapper.toDto(user);
    }

    @GetMapping("/{userId}")
    public UserResponseDto getById(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return userMapper.toDto(user);
    }

    @GetMapping("/by-phone")
    public UserResponseDto getByPhoneNumber(@RequestParam String phoneNumber) {
        User user = userService.getByPhone(phoneNumber);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.remove(userId);
    }
}
