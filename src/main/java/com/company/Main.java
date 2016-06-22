package com.company;

import com.company.controllers.DishController;
import com.company.controllers.EmployeeController;
import com.company.controllers.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final String EMPLOYEE_NAME_FOR_NAME = "John";
    private static final String DISH_NAME_FOR_SEARCH = "Plov";

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

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
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();

        System.out.println("All employees:");
        employeeController.getAllEmployees().forEach(System.out::println);

        System.out.println("All dishes:");
        dishController.getAllDishes().forEach(System.out::println);

        System.out.println("Employee with name " + EMPLOYEE_NAME_FOR_NAME);
        System.out.println(employeeController.getEmployeeByName(EMPLOYEE_NAME_FOR_NAME));

        System.out.println("Dish with name " + DISH_NAME_FOR_SEARCH);
        System.out.println(dishController.getDishByName(DISH_NAME_FOR_SEARCH));
    }
}
