package com.example.login.repository;

import com.example.login.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long > {
    Optional<PermissionEntity> findByName(String name);
}
