package com.banking.bankservice.service.impl;

import com.banking.bankservice.model.Role;
import com.banking.bankservice.repository.RoleRepository;
import com.banking.bankservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.getByName(name).get();
    }
}
