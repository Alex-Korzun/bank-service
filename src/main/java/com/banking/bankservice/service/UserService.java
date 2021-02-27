package com.banking.bankservice.service;

import com.banking.bankservice.model.User;
import java.util.Optional;

public interface UserService {
    User create(User user);

    User update(User user);

    Optional<User> getById(Long id);

    Optional<User> getByPhone(String phone);

    void remove(Long id);
}
