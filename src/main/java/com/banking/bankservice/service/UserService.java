package com.banking.bankservice.service;

import com.banking.bankservice.model.User;

public interface UserService {
    User save(User user);

    User getById(Long id);

    User getByPhone(String phone);

    void remove(Long id);
}
