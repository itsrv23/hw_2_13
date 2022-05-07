package ru.itsrv23.hw213.service.impl;

import org.springframework.stereotype.Service;
import ru.itsrv23.hw213.entity.Employee;
import ru.itsrv23.hw213.exceptions.EmployeeNotFoundException;
import ru.itsrv23.hw213.service.DepartmentsService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentsServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployeeByDepartment(Integer departmentId) {
        return employeeService.getEmployeeBookMap()
                .values()
                .stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList())
                .stream().max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMixSalaryEmployeeByDepartment(Integer departmentId) {
        return employeeService.getEmployeeBookMap()
                .values()
                .stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList())
                .stream().min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeeByDepartment(Integer departmentId) {
        return employeeService.getEmployeeBookMap()
                .values()
                .stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employeeService.getEmployeeBookMap().values());
    }
}
