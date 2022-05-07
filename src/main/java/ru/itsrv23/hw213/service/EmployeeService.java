package ru.itsrv23.hw213.service;


import ru.itsrv23.hw213.entity.Employee;

import java.util.Map;

public interface EmployeeService {
    Map<String, Employee> getEmployeeBookMap();
    Employee addEmployee(String firstName, String lastName, String patronymic, Integer salary, Integer department);
    Employee deleteEmployee(String firstName, String lastName,String patronymic);
    Employee findEmployee(String firstName, String lastName, String patronymic);
}
