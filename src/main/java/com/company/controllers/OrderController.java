package com.company.controllers;

import com.company.dao.DishDao;
import com.company.dao.EmployeeDao;
import com.company.model.Dish;
import com.company.model.Order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yevhen on 06.06.2016.
 */
public class OrderController {
    private EmployeeDao employeeDao;
    private DishDao dishDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Order order = new Order();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDateTime(new Timestamp(new Date().getTime()));

    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName: dishes) {
            result.add(dishDao.findByName(dishName));
        }

        return result;

    }
}
