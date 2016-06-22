package com.company.dao;

import com.company.model.Order;

import java.util.List;

/**
 * Created by Yevhen on 06.06.2016.
 */
public interface OrderDao {

    void save(Order order);

    List<Order> findAllOrders();
}
