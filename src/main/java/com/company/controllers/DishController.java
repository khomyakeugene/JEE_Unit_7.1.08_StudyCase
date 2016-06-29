package com.company.controllers;

import com.company.dao.DishDao;
import com.company.model.Dish;
import com.company.model.DishCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yevhen on 06.06.2016.
 */
public class DishController {

    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional
    public void initDishes() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(5.00F);
        plov.setWeight(0.300F);
        dishDao.save(plov);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SALAD);
        salad.setPrice(2.00F);
        salad.setWeight(0.200F);
        dishDao.save(salad);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(3.00F);
        potato.setWeight(0.100F);
        dishDao.save(potato);
    }


    @Transactional
    public void removeAllDishes() {
        dishDao.removeAll();
    }
}
