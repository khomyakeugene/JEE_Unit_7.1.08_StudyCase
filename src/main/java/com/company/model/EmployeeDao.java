package com.company.model;

import java.util.List;

/**
 * Created by Yevhen on 05.06.2016.
 */
public interface EmployeeDao {
    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    void remove(Employee employee);
}
