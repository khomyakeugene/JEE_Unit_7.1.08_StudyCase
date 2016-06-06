package com.company.dao.hibernate;

import com.company.model.Order;
import com.company.dao.OrderDao;
import org.hibernate.SessionFactory;

/**
 * Created by Yevhen on 06.06.2016.
 */
public class HOrderDao implements OrderDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
