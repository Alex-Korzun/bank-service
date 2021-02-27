package com.banking.bankservice.service.impl;

import com.banking.bankservice.model.User;
import com.banking.bankservice.repository.UserRepository;
import com.banking.bankservice.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Optional<User> getByPhone(String phone) {
        return userRepository.getByPhone(phone);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}