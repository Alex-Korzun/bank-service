package com.banking.bankservice.service;

import com.banking.bankservice.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByRoleName(String name);
}
