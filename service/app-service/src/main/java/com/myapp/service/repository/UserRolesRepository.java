package com.myapp.service.repository;

import com.myapp.service.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRole,String> {
}
