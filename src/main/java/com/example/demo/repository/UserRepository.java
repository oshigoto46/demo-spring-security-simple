package com.example.demo.repository;

import com.example.demo.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User2, Long> {
  Optional<User2> findByEmail(String email);
}
