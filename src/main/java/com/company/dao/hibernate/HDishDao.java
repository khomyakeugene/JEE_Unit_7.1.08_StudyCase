package com.company.dao.hibernate;

import com.company.dao.DishDao;
import com.company.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
        return sessionFactory.getCurrentSession().createQuery("from Dish", Dish.class).list();
    }

    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Dish> query = session.createQuery("from Dish where name like :name", Dish.class);
        query.setParameter("name", name);

        return query.uniqueResult();
    }
}
