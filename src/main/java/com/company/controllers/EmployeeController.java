package com.company.controllers;

import com.company.model.Employee;
import com.company.dao.EmployeeDao;
import com.company.model.Position;
import com.company.model.Waiter;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
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
        employeeDao.save(employee);

        return employee;
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }


    @Transactional
    public void initEmployees() {
        Waiter john = new Waiter();
        john.setName("John");
        john.setSurname("Smith");
        john.setPosition(Position.WAITER);
        john.setPhoneNumber("555-55-55");
        john.setSalary(25000.0F);
        employeeDao.save(john);

        Waiter mary = new Waiter();
        mary.setName("Mary");
        mary.setSurname("Smith");
        mary.setPosition(Position.WAITER);
        mary.setPhoneNumber("555-55-55");
        mary.setSalary(25000.0F);
        employeeDao.save(mary);
    }

    @Transactional
    public void removeAllEmployees() {
        employeeDao.removeAll();
    }

    @Transactional
    public void printEmployee(Long id) {
        System.out.println(employeeDao.load(id));
    }
}
