package com.company;

import com.company.controllers.DishController;
import com.company.controllers.EmployeeController;
import com.company.controllers.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String EMPLOYEE_NAME_FOR_NAME = "John";
    private static final String DISH_NAME_FOR_SEARCH = "Plov";

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    private boolean reInit;

    public void setReInit(boolean reInit) {
        this.reInit = reInit;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        applicationContext.getBean(Main.class).start();
    }

    private void start() {
        employeeController.printEmployee(2L);
        employeeController.printEmployee(2L);
    }

    public void init() {
        if (reInit) {
            orderController.removeAllOrders();
            employeeController.removeAllEmployees();
            dishController.removeAllDishes();

            employeeController.initEmployees();
            dishController.initDishes();
            orderController.initOrders();
        }
    }
}
