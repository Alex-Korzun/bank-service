package com.banking.bankservice.mapper.impl;

import com.banking.bankservice.mapper.UserMapper;
import com.banking.bankservice.model.Role;
import com.banking.bankservice.model.User;
import com.banking.bankservice.model.dto.request.UserRequestDto;
import com.banking.bankservice.model.dto.response.UserResponseDto;

import java.time.LocalDate;

public class UserMapperImpl implements UserMapper {
    @Override
    public User fromDto(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setDateOfBirth(LocalDate.parse(userRequestDto.getDateOfBirth()));
        user.setPassword(userRequestDto.getPassword());
        user.setPhoneNumber(user.getPhoneNumber());
        return user;
    }

    @Override
    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .dateOfBirth(user.getDateOfBirth().toString())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
