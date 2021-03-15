package com.banking.bankservice.util;

import com.banking.bankservice.model.Role;
import com.banking.bankservice.model.User;
import com.banking.bankservice.service.RoleService;
import com.banking.bankservice.service.UserService;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        User admin = new User();
        admin.setName("admin");
        admin.setPhoneNumber("0661237698");
        admin.setPassword("admin");
        admin.setDateOfBirth(LocalDate.of(1989, 4, 25));
        Role adminRole = new Role();
        adminRole.setRoleName(Role.Roles.ADMIN);
        roleService.save(adminRole);
        userService.save(admin);
    }
}
