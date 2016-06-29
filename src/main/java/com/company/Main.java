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

    /*
    private void start() {

        employeeController.createEmployee();
        dishController.createDish();

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");
        orderController.createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Potato");
        dishes2.add("Salad");
        orderController.createOrder("John", dishes2, 2);

        System.out.println("All employees:");
        employeeController.getAllEmployees().forEach(System.out::println);

        System.out.println("All dishes:");
        dishController.getAllDishes().forEach(System.out::println);

        System.out.println("Employee with name " + EMPLOYEE_NAME_FOR_NAME);
        System.out.println(employeeController.getEmployeeByName(EMPLOYEE_NAME_FOR_NAME));

        System.out.println("Dish with name " + DISH_NAME_FOR_SEARCH);
        System.out.println(dishController.getDishByName(DISH_NAME_FOR_SEARCH));

        orderController.printAllOrders();
    }
*/

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
