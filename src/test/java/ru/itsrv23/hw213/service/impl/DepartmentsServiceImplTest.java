package ru.itsrv23.hw213.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itsrv23.hw213.entity.Employee;
import ru.itsrv23.hw213.exceptions.DepartmentIsNotExistsException;
import ru.itsrv23.hw213.exceptions.EmployeeNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.itsrv23.hw213.constance.DepartmentsServiceImplTestConstance.*;

@ExtendWith(MockitoExtension.class)
class DepartmentsServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    public DepartmentsServiceImpl out;

    @Test
        //Такое наименование методов на мой взгляд более функциональное
        //Сначала пишем метод, а потом что ожидаем получить
    void getMaxSalaryEmployeeByDepartment_ShouldReturnEmployee() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_DEPARTMENT_1);
        Employee actual = out.getMaxSalaryEmployeeByDepartment(DEPARTMENT);
        assertEquals(EMPLOYEE_MAX_SALARY_IN_DEPARTMENT, actual);
    }

    @Test
    void getMaxSalaryEmployeeByDepartment_ShouldThrowException() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_DEPARTMENT_1);
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryEmployeeByDepartment(DEPARTMENT_NOT_EXISTS));
    }

    @Test
    void getMinSalaryEmployeeByDepartment_ShouldReturnEmployee() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_DEPARTMENT_1);
        Employee actual = out.getMinSalaryEmployeeByDepartment(DEPARTMENT);
        assertEquals(EMPLOYEE_MIN_SALARY_IN_DEPARTMENT, actual);
    }

    @Test
    void getMinSalaryEmployeeByDepartment_ShouldThrowException() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_DEPARTMENT_1);
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryEmployeeByDepartment(DEPARTMENT_NOT_EXISTS));
    }

    @Test
    void getAllEmployeeByDepartment_ShouldReturnListEmployee() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_DEPARTMENT_1);
        List<Employee> expected = EMPLOYEE_LIST_DEPARTMENT_1;
        List<Employee> actual = out.getAllEmployeeByDepartment(DEPARTMENT);
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    void getAllEmployeeByDepartment_ShouldThrowExceptionNotDepartment() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_EMPTY);
        assertThrows(DepartmentIsNotExistsException.class, () -> out.getAllEmployeeByDepartment(DEPARTMENT_NOT_EXISTS));
    }

    @Disabled  // Отключаем прохождение теста. С целью, дописать функционал в будущем
    @Test
    void getAllEmployeeByDepartment_ShouldThrowExceptionEmptyList() {
        //Так как у нас нет отдельного списка департаментов, проверка не актуальна
    }

    @Test
    void getAllEmployee_ShouldReturnEmployeeList() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP);
        List<Employee> expected = EMPLOYEE_LIST;
        List<Employee> actual = out.getAllEmployee();
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }
    @Test
    void getAllEmployee_ShouldThrowExceptionEmptyList() {
        when(employeeServiceMock.getEmployeeBookMap()).thenReturn(EMPLOYEE_BOOK_MAP_EMPTY);
        assertThrows(EmployeeNotFoundException.class, ()-> out.getAllEmployee());
    }
}