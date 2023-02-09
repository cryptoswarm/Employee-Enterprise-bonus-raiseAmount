package com.app.employeeEnterprise.service;

import com.app.employeeEnterprise.dtos.RoleDto;
import com.app.employeeEnterprise.helpers.RoleMapper;
import com.app.employeeEnterprise.logging.SL4JLogger;
import com.app.employeeEnterprise.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService implements  IRoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleDto saveRole(RoleDto roleDto) {

        var role = RoleMapper.INSTANCE.roleDtoToRole(roleDto);

        SL4JLogger.getLogger().info("Adding role {} to the database", role.getRoleName());

        return  RoleMapper.INSTANCE.roleToRoleDto(this.roleRepository.save(role));
    }
}
