package com.company.dao.hibernate;

import com.company.model.Dish;
import com.company.dao.DishDao;
import org.hibernate.SessionFactory;

/**
 * Created by Yevhen on 06.06.2016.
 */
public class HDishDao implements DishDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }
}
