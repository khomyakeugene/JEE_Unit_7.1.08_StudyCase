package com.company.controllers;

import com.company.dao.DishDao;
import com.company.dao.EmployeeDao;
import com.company.dao.OrderDao;
import com.company.model.Dish;
import com.company.model.Order;
import org.springframework.transaction.annotation.Transactional;

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
    private OrderDao orderDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName: dishes) {
            result.add(dishDao.findByName(dishName));
        }

        return result;
    }

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Order order = new Order();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDateTime(new Timestamp(new Date().getTime()));

        orderDao.save(order);
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.findAllOrders();
    }

    @Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }
}
