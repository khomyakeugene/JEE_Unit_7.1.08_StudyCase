package com.company;

import com.company.controllers.DishController;
import com.company.controllers.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();

        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);
    }
}
