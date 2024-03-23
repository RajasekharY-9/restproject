package com.iny.restproject.repo;

import com.iny.restproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserId(String userId);
    //void save(User user);

}