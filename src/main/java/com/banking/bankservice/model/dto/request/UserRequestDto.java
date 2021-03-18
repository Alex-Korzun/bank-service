package com.banking.bankservice.model.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String password;
    private String dateOfBirth;
    private String phoneNumber;
}
