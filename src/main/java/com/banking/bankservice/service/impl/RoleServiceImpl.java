package com.banking.bankservice.service.impl;

import com.banking.bankservice.exception.NoSuchEntityException;
import com.banking.bankservice.model.Role;
import com.banking.bankservice.repository.RoleRepository;
import com.banking.bankservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByRoleName(String name) {
        return roleRepository.getByRoleName(Role.Roles.valueOf(name))
                .orElseThrow(() -> new NoSuchEntityException("Can't get Role by name " + name));
    }
}
