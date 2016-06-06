package com.company.dao.hibernate;

import com.company.model.Dish;
import com.company.dao.DishDao;
import org.hibernate.SessionFactory;

import java.util.List;

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

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }
}
