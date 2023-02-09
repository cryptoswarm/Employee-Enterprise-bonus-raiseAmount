package com.app.employeeEnterprise.helpers;

import com.app.employeeEnterprise.dtos.EmployeeDto;
import com.app.employeeEnterprise.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    EmployeeDto employeeToEmployeeDto(Employee employee);
    List<EmployeeDto> employeesToEmployeesDto(List<Employee> employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDTO);
}