package ru.itsrv23.hw213.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itsrv23.hw213.entity.Employee;
import ru.itsrv23.hw213.service.impl.DepartmentsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsServiceImpl departmentsService;


    public DepartmentsController(DepartmentsServiceImpl departmentsService) {
        this.departmentsService = departmentsService;
    }

    // /departments/max-salary?departmentId=5
    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployeeByDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return departmentsService.getMaxSalaryEmployeeByDepartment(departmentId);
    }

    // /departments/min-salary?departmentId=5
    @GetMapping("/min-salary")
    public Employee getMixSalaryEmployeeByDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return departmentsService.getMixSalaryEmployeeByDepartment(departmentId);
    }

    // /departments/all?departmentId=5
    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> getAllEmployeeByDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return departmentsService.getAllEmployeeByDepartment(departmentId);
    }

    // /departments/all
    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return departmentsService.getAllEmployee();
    }

}
