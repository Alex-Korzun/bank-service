package com.banking.bankservice.mapper;

import com.banking.bankservice.model.User;
import com.banking.bankservice.model.dto.request.UserRequestDto;
import com.banking.bankservice.model.dto.response.UserResponseDto;

public interface UserMapper {
    User fromDto(UserRequestDto userRequestDto);

    UserResponseDto toDto(User user);
}
