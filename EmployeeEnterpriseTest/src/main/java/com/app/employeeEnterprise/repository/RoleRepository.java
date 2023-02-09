package com.app.employeeEnterprise.repository;

import com.app.employeeEnterprise.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

        Role findByRoleName(String roleName);
}
