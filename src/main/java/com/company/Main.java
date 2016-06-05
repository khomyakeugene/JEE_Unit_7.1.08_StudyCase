package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context");
        Main main = applicationContext.getBean(Main.class);
        main.start();
        
    }

    private void start() {
    }
}
