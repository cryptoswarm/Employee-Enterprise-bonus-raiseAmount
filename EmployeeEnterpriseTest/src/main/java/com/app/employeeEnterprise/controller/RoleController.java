package com.app.employeeEnterprise.controller;

import com.app.employeeEnterprise.dtos.RoleDto;
import com.app.employeeEnterprise.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles").toUriString());
        RoleDto newRole = this.roleService.saveRole(roleDto);

        return ResponseEntity.created(uri).body(newRole);
    }
}
