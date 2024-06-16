package com.ddev.userservice.repositories;

import com.ddev.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
