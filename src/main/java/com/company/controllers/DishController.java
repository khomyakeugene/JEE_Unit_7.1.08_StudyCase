package com.company.controllers;

import com.company.dao.DishDao;
import com.company.model.Dish;
import com.company.model.DishCategory;

/**
 * Created by Yevhen on 06.06.2016.
 */
public class DishController {

    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void createDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(5.00F);
        plov.setWeight(0.300F);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SALAD);
        salad.setPrice(2.00F);
        salad.setWeight(0.200F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(3.00F);
        potato.setWeight(0.100F);

        dishDao.save(plov);
        dishDao.save(salad);
        dishDao.save(potato);
    }
}
