package com.AnimalLoversSociety.MyApplication.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);

    @Query(value = "SELECT r.name " +
            "FROM roles r " +
            "JOIN users_roles ur ON r.role_id = ur.role_id " +
            "JOIN users u ON ur.user_id = u.user_id " +
            "WHERE u.username = :username", nativeQuery = true)
    public List<String> getRoleNamesByUsername(String username);
}
