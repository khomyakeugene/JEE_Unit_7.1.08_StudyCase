package com.company.model.controllers;

import com.company.model.Employee;
import com.company.model.EmployeeDao;
import com.company.model.Position;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yevhen on 05.06.2016.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();

        //employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        employeeDao.save(employee);
    }
}
