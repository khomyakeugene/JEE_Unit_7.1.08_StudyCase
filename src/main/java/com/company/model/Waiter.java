package com.company.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Yevhen on 29.06.2016.
 */
@Entity
public class Waiter extends Employee {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "orders=" + orders +
                '}';
    }
}

