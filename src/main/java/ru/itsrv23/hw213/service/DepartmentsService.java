package ru.itsrv23.hw213.service;

import ru.itsrv23.hw213.entity.Employee;

import java.util.List;

public interface DepartmentsService {
    Employee getMaxSalaryEmployeeByDepartment(Integer departmentId);
    Employee getMixSalaryEmployeeByDepartment(Integer departmentId);
    List<Employee> getAllEmployeeByDepartment(Integer departmentId);
    List<Employee> getAllEmployee();
}
