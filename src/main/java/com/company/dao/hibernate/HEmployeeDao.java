package com.company.dao.hibernate;

import com.company.model.Employee;
import com.company.dao.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Yevhen on 05.06.2016.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class).list();
    }

    @Override
    public Employee findByName(String name) {
        Query<Employee> query = sessionFactory.getCurrentSession().createQuery("FROM Employee WHERE name LIKE :name", Employee.class);
        query.setParameter("name", name);

        return query.uniqueResult();
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }
}
