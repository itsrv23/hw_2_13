package ru.itsrv23.hw213.service.impl;

import org.junit.jupiter.api.Test;
import ru.itsrv23.hw213.entity.Employee;
import ru.itsrv23.hw213.exceptions.EmployeeIsExistsException;
import ru.itsrv23.hw213.exceptions.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import static ru.itsrv23.hw213.constance.EmployeeServiceImplTestConstance.*;


class EmployeeServiceImplTest {

    EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    void shouldAddEmployeeAndReturnThisEmployee() {
        Employee actual = out.addEmployee(NAME, LASTNAME, PATRONYMIC, SALARY, DEPARTMENT);
        assertEquals(EMPLOYEE, actual);
    }

    @Test
    void shouldAddEmployeeIfExistsAndThrow() {
        out.addEmployee(NAME, LASTNAME, PATRONYMIC, SALARY, DEPARTMENT);
        assertThrows(EmployeeIsExistsException.class,() -> out.addEmployee(NAME, LASTNAME, PATRONYMIC, SALARY, DEPARTMENT));
    }

    @Test
    void shouldDeleteEmployeeAndReturnDeletedEmployeeIfExists() {
        out.addEmployee(NAME, LASTNAME, PATRONYMIC, SALARY, DEPARTMENT);
        Employee actual = out.deleteEmployee(NAME, LASTNAME, PATRONYMIC);
        assertEquals(EMPLOYEE, actual);
    }

    @Test
    void shouldDeleteEmployeeAndReturnDeletedEmployeeIfNotExists() {
        assertThrows(EmployeeNotFoundException.class,() -> out.deleteEmployee(NAME, LASTNAME, PATRONYMIC));
    }


    @Test
    void shouldFindEmployeeIfExists() {
        out.addEmployee(NAME, LASTNAME, PATRONYMIC, SALARY, DEPARTMENT);
        Employee actual =  out.findEmployee(NAME, LASTNAME, PATRONYMIC);
        assertEquals(EMPLOYEE, actual);
    }

    @Test
    void shouldFindEmployeeIfNotExists() {
        assertThrows(EmployeeNotFoundException.class,() -> out.findEmployee(NAME, LASTNAME, PATRONYMIC));
    }
}