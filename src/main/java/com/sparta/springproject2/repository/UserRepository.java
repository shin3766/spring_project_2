package com.sparta.springproject2.repository;

import com.sparta.springproject2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
