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

    @Transactional
    @Override
    public Employee load(Long id) {
        Query<Employee> query = sessionFactory.getCurrentSession().createQuery("FROM Employee WHERE id = :id", Employee.class);
        query.setParameter("id", id);

        return query.uniqueResult();
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Employee", Employee.class).list();
    }

    @Transactional
    @Override
    public Employee findByName(String name) {
        Query<Employee> query = sessionFactory.getCurrentSession().createQuery("FROM Employee WHERE name LIKE :name", Employee.class);
        query.setParameter("name", name);

        return query.uniqueResult();
    }

    @Transactional
    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Transactional
    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee").executeUpdate();
    }
}
