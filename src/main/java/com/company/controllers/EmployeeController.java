package com.company.controllers;

import com.company.model.Employee;
import com.company.dao.EmployeeDao;
import com.company.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yevhen on 05.06.2016.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public Employee createEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();

        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);
        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }

        return employee;
    }
}
