package ru.itsrv23.hw213.service.impl;

import org.springframework.stereotype.Service;
import ru.itsrv23.hw213.entity.Employee;
import ru.itsrv23.hw213.exceptions.DepartmentIsNotExistsException;
import ru.itsrv23.hw213.exceptions.EmployeeNotFoundException;
import ru.itsrv23.hw213.service.DepartmentsService;
import ru.itsrv23.hw213.service.EmployeeService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    private final EmployeeService employeeService;

    public DepartmentsServiceImpl(EmployeeService employeeService) {
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
    public Employee getMinSalaryEmployeeByDepartment(Integer departmentId) {
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
        List<Employee> result = employeeService.getEmployeeBookMap()
                .values()
                .stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            //так как у нас нет списка департаментов, и лист пустой, значит выкидываем ошибку
            throw new DepartmentIsNotExistsException();
        }

        return result;
    }

    @Override
    public List<Employee> getAllEmployee() {
        ArrayList<Employee> employees = new ArrayList<>(employeeService.getEmployeeBookMap().values());
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employees;
    }
}
