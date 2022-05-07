package ru.itsrv23.hw213.service.impl;

import org.springframework.stereotype.Service;
import ru.itsrv23.hw213.entity.Employee;
import ru.itsrv23.hw213.exceptions.EmployeeIsExistsException;
import ru.itsrv23.hw213.exceptions.EmployeeNotFoundException;
import ru.itsrv23.hw213.service.EmployeeService;
import ru.itsrv23.hw213.utils.ValidatorUserNames;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeBookMap;

    public EmployeeServiceImpl() {
        this.employeeBookMap =  new HashMap<>();
    }
    //Добавил в сервис
    @Override
    public Map<String, Employee> getEmployeeBookMap() {
        return employeeBookMap;
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employeeBook=" + employeeBookMap +
                '}';
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, String patronymic, Integer salary, Integer department) {

        firstName = ValidatorUserNames.check(firstName);
        lastName = ValidatorUserNames.check(lastName);

        // Проверка для тех у кого нет отчества
        if(patronymic != null && !patronymic.equals("")) {
            patronymic = ValidatorUserNames.check(patronymic);
        }

        String fio =  getFIO(firstName, lastName, patronymic);
        if (employeeBookMap.containsKey(fio)) {
            throw new EmployeeIsExistsException();
        } else {
            Employee employee = new Employee(firstName, lastName, patronymic, salary, department);
            employeeBookMap.put(fio,employee);
            return employee;
        }
    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName, String patronymic) {
        String fio =  getFIO(firstName, lastName, patronymic);
        if (!employeeBookMap.containsKey(fio)) {
            throw new EmployeeNotFoundException();
        } else {
            return employeeBookMap.remove(fio);
        }

    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String patronymic) {
        String fio =  getFIO(firstName, lastName, patronymic);
        if (employeeBookMap.containsKey(fio)) {
            return employeeBookMap.get(fio);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    // Метод используется только в этом классе, и как показала практика нигде более, сделал приватным
    private String getFIO(String firstName, String lastName, String patronymic) {
        return firstName + " " +  lastName + " " + patronymic;
    }


}

