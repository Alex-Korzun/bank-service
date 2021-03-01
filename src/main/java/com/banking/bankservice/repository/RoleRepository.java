package com.banking.bankservice.repository;

import com.banking.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getByRoleName(Role.Roles roleName);
}
