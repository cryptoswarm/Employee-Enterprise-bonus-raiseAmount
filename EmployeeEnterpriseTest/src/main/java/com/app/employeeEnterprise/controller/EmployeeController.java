package com.app.employeeEnterprise.controller;

import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.model.Role;
import com.app.employeeEnterprise.service.EmployeeService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees()
    {
        /*Employee employee = new Employee("SAFM11",
                                            "saf",
                                            "mok",
                                            3,
                                            2000,
                                            'P');*/
        //List<Employee> employeeList = new ArrayList<>();
        //employeeList.add(employee);
        return ResponseEntity.ok().body(employeeService.getEmployees());
        //return ResponseEntity.ok().body(employeeList);
    }

    @PostMapping("/employee/save")
    public ResponseEntity<Employee> saveEmployees( @RequestBody Employee employee)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/employee/save").toUriString());
        Employee newEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.created(uri).body(newEmployee);
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        Role newRole = employeeService.saveRole(role);
        return ResponseEntity.created(uri).body(newRole);
    }

    @PostMapping("/role/add-to-employee")
    public ResponseEntity<?> addRoleToEmployee(@RequestBody RoleToEmployee form)
    {
        employeeService.addRoleToEmployee(form.getEmployeeRegistration(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());//using same secret that we used to sign the algorithm
                JWTVerifier verifier = JWT.require(algorithm).build(); //build the verifier
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject(); //username is the employee registration
                Employee employee = employeeService.getEmployee(username);

                String access_token = JWT.create()
                        .withSubject(employee.getEmployeeRegistration())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) //adding 10 min to the current time
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("role", employee.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> token = new HashMap<>();
                token.put("access_token", access_token);
                token.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), token);

            }catch (Exception ex)
            {
                response.setHeader("error", ex.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", ex.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}

class RoleToEmployee
{
    private String employeeRegistration;
    private String roleName;

    public RoleToEmployee(String employeeRegistration, String roleName) {

        this.employeeRegistration = employeeRegistration;
        this.roleName = roleName;
    }

    public String getEmployeeRegistration() {
        return employeeRegistration;
    }

    public String getRoleName() {
        return roleName;
    }
}
