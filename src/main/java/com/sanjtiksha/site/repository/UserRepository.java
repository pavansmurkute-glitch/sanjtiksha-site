package com.sanjtiksha.site.repository;

import com.sanjtiksha.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
