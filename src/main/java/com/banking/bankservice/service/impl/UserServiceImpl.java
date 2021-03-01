package com.banking.bankservice.service.impl;

import com.banking.bankservice.model.User;
import com.banking.bankservice.repository.UserRepository;
import com.banking.bankservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id).get();
    }

    @Override
    public User getByPhone(String phone) {
        return userRepository.getByPhone(phone).get();
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
