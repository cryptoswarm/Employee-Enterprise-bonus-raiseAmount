package com.app.employeeEnterprise.helpers;
import com.app.employeeEnterprise.dtos.RoleDto;
import com.app.employeeEnterprise.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper( RoleMapper.class );

    RoleDto roleToRoleDto(Role role);
    List<RoleDto> employeesRolesToEmployeesRoleDto(List<Role> roles);

    Role roleDtoToRole(RoleDto roleDto);
}
