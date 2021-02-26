package com.banking.bankservice.Repository;

import com.banking.bankservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
