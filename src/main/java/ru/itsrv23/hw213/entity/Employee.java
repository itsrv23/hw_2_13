package ru.itsrv23.hw213.entity;

import java.util.Objects;


public class Employee {
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final Integer salary;
    private final Integer department;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public Employee(String name, String lastName, String patronymic, Integer salary, Integer department) {
        this.firstName = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.salary = salary;
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic);
    }

    public String getFIO() {
        return firstName + " " +  lastName + " " + patronymic;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
