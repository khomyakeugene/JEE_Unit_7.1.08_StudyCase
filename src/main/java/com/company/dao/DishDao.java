package com.company.dao;

import com.company.model.Dish;

import java.util.List;

/**
 * Created by Yevhen on 06.06.2016.
 */
public interface DishDao {
    void save(Dish dish);

    List<Dish> findAll();

    Dish findByName(String name);
}
