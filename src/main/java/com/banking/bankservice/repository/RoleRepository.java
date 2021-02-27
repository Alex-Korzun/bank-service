package com.banking.bankservice.repository;

import com.banking.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Roles r WHERE r.roleName = ?1")
    Optional<Role> getByName(String name);
}
