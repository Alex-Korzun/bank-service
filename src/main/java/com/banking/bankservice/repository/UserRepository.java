package com.banking.bankservice.repository;

import com.banking.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM Users u LEFT JOIN FETCH u.roles WHERE u.id = ?1")
    Optional<User> getById(Long id);

    @Query("SELECT u FROM Users u LEFT JOIN FETCH u.roles WHERE u.phoneNumber = ?1")
    Optional<User> getByPhone(String phone);
}
