package ru.itsrv23.hw213.constance;

import ru.itsrv23.hw213.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentsServiceImplTestConstance {
    public static final Employee EMPLOYEE_1 = new Employee("Ivan", "Ivanov", "Ivanovich", 1000, 1);
    public static final Employee EMPLOYEE_2 = new Employee("Petr", "Ivanov", "Ivanovich", 2000, 2);
    public static final Employee EMPLOYEE_3 = new Employee("Andrey", "Ivanov", "Ivanovich", 3000, 1);
    public static final Integer DEPARTMENT = 1;
    public static final Integer DEPARTMENT_NOT_EXISTS = Integer.MAX_VALUE;
    public static final Employee EMPLOYEE_MIN_SALARY_IN_DEPARTMENT = EMPLOYEE_1;
    public static final Employee EMPLOYEE_MAX_SALARY_IN_DEPARTMENT = EMPLOYEE_3;
    public static final Map<String, Employee> EMPLOYEE_BOOK_MAP_EMPTY = new HashMap<>();
    public static final Map<String, Employee> EMPLOYEE_BOOK_MAP = new HashMap<>(Map.of(
            EMPLOYEE_1.getFIO(), EMPLOYEE_1,
            EMPLOYEE_2.getFIO(), EMPLOYEE_2,
            EMPLOYEE_3.getFIO(), EMPLOYEE_3
    )
    );

    public static final Map<String, Employee> EMPLOYEE_BOOK_MAP_DEPARTMENT_1 = new HashMap<>(Map.of(
            EMPLOYEE_1.getFIO(), EMPLOYEE_1,
            EMPLOYEE_3.getFIO(), EMPLOYEE_3
    )
    );

    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT_1 = List.of(EMPLOYEE_1, EMPLOYEE_3);
    public static final List<Employee> EMPLOYEE_LIST = List.of(EMPLOYEE_1,EMPLOYEE_2, EMPLOYEE_3);

}
