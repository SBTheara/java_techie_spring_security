package com.intern.theara.springsecurity.JavaTechie_SpringSecurity.repository;

import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
}
